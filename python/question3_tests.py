"""
Test infrastructure for Problem 3 -- Largest K With Its Negative.
Contains reference solution, input generators, and all test cases.
"""

import random
from test_harness import TestHarness, Case


def build_harness(solve_fn):
    """Build a fully configured test harness for Problem 3."""
    stress_rng = random.Random(123)
    large_input = _gen(1000, 1000)

    return TestHarness("Largest K With Its Negative") \
        .add_test("Example 1",
            lambda: solve_fn([-1, 2, -3, 3]),
            3) \
        .add_test("Example 2",
            lambda: solve_fn([-1, 10, 6, 7, -7, 1]),
            7) \
        .add_test("Example 3 - no match",
            lambda: solve_fn([-10, 8, 6, 7, -2, -3]),
            -1) \
        .add_test("All positives",
            lambda: solve_fn([1, 2, 3, 4]),
            -1) \
        .add_test("All negatives",
            lambda: solve_fn([-1, -2, -3, -4]),
            -1) \
        .add_test("Single pair",
            lambda: solve_fn([-5, 5]),
            5) \
        .add_test("Multiple pairs -> largest wins",
            lambda: solve_fn([-1, 1, -2, 2, -3, 3]),
            3) \
        .add_test("Boundary values",
            lambda: solve_fn([-1000, 1000, -999, 999]),
            1000) \
        .add_test("Edge: single element",
            lambda: solve_fn([7]),
            -1) \
        .add_test("Edge: mirror pair at boundary",
            lambda: solve_fn([-1, 1]),
            1) \
        .add_scaling("N (array size, values in [-1000..1000])",
            [10, 50, 100, 200, 500, 1_000],
            lambda n: _gen(n, 1000),
            lambda inp: solve_fn(inp),
            lambda inp: _brute_force(inp)) \
        .add_random_tests("Stress test (N=1..100, values in [-50..50])", 1_000,
            lambda: (
                lambda n=stress_rng.randint(1, 100):
                    (lambda inp=_gen(n, 50, stress_rng.randint(0, 10**6)):
                        Case(f"N={n}", lambda i=inp: solve_fn(i[:]), _brute_force(inp))
                    )()
            )()) \
        .add_benchmark("Random (N = 1,000)",
            lambda: solve_fn(large_input[:]))


# ── Reference solution ───────────────────────────────────

def _brute_force(nums):
    s = set(nums)
    best = -1
    for v in s:
        if v > 0 and -v in s:
            best = max(best, v)
    return best


# ── Input generators ─────────────────────────────────────

def _gen(n, max_abs, seed=42):
    rng = random.Random(seed)
    arr = []
    for _ in range(n):
        v = rng.randint(-max_abs, max_abs - 1)
        if v >= 0:
            v += 1  # skip zero
        arr.append(v)
    return arr
