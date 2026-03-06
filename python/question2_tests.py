"""
Test infrastructure for Problem 2 -- Two Sum (Bounded Values).
Contains reference solution, input generators, and all test cases.
"""

import random
from test_harness import TestHarness, Case


def build_harness(solve_fn):
    """Build a fully configured test harness for Problem 2."""
    stress_rng = random.Random(123)
    large_input = _gen(5_000_000, -100_000, 100_000)

    return TestHarness("Two Sum (Bounded Values)") \
        .add_test("Pair exists (endpoints)",
            lambda: solve_fn([1, 3, 5, 7], 8),
            True) \
        .add_test("Pair exists (middle)",
            lambda: solve_fn([2, 4, 6, 8], 10),
            True) \
        .add_test("No pair",
            lambda: solve_fn([1, 2, 3], 10),
            False) \
        .add_test("Negative numbers",
            lambda: solve_fn([-5, 3, 2, 10], -2),
            True) \
        .add_test("Duplicate needed",
            lambda: solve_fn([4, 4], 8),
            True) \
        .add_test("Single element can't pair with itself",
            lambda: solve_fn([5], 10),
            False) \
        .add_test("Zeros",
            lambda: solve_fn([0, 0, 1], 0),
            True) \
        .add_test("Boundary values",
            lambda: solve_fn([-100_000, 100_000], 0),
            True) \
        .add_test("Edge: target at boundary",
            lambda: solve_fn([100_000, 100_000], 200_000),
            True) \
        .add_test("Edge: negative target at boundary",
            lambda: solve_fn([-100_000, -100_000], -200_000),
            True) \
        .add_test("Edge: single element",
            lambda: solve_fn([42], 84),
            False) \
        .add_scaling("N (array size, values in [-1000..1000])",
            [100, 500, 1_000, 5_000, 10_000],
            lambda n: _gen(n, -1_000, 1_000),
            lambda inp: solve_fn(inp, 42),
            lambda inp: _brute_force(inp, 42)) \
        .add_random_tests("Stress test (N=1..50, values in [-20..20])", 1_000,
            lambda: (
                lambda n=stress_rng.randint(1, 50), t=stress_rng.randint(-40, 40):
                    (lambda a=_gen(n, -20, 20, stress_rng.randint(0, 10**6)):
                        Case(f"N={n} target={t}", lambda a=a, t=t: solve_fn(a[:], t), _brute_force(a, t))
                    )()
            )()) \
        .add_benchmark("Large random (N = 5,000,000)",
            lambda: solve_fn(large_input[:], 42))


# ── Reference solution ───────────────────────────────────

def _brute_force(A, target):
    for i in range(len(A)):
        for j in range(i + 1, len(A)):
            if A[i] + A[j] == target:
                return True
    return False


# ── Input generators ─────────────────────────────────────

def _gen(n, lo, hi, seed=42):
    rng = random.Random(seed)
    return [rng.randint(lo, hi) for _ in range(n)]
