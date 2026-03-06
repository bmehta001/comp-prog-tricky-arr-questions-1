"""
Test infrastructure for Problem 1 -- Cow Sighting Frequency.
Contains reference solution, input generators, and all test cases.
"""

import random
from collections import Counter
from test_harness import TestHarness, Case


def build_harness(solve_fn):
    """Build a fully configured test harness for Problem 1."""
    stress_rng = random.Random(123)
    large_input = _gen(200_000, 1_000_000)

    return TestHarness("Cow Sighting Frequency") \
        .add_test("Basic test",
            lambda: solve_fn([1, 2, 1, 3, 1]),
            (1, 3)) \
        .add_test("Single element",
            lambda: solve_fn([5]),
            (5, 1)) \
        .add_test("All same",
            lambda: solve_fn([42, 42, 42]),
            (42, 3)) \
        .add_test("Tie -> smallest ID wins",
            lambda: solve_fn([3, 3, 2, 2]),
            (2, 2)) \
        .add_test("Large IDs",
            lambda: solve_fn([999_999, 1_000_000, 999_999]),
            (999_999, 2)) \
        .add_test("Edge: two elements, different, ascending",
            lambda: solve_fn([1, 2]),
            (1, 1)) \
        .add_test("Edge: two elements, different, descending",
            lambda: solve_fn([2, 1]),
            (1, 1)) \
        .add_test("Edge: max ID only",
            lambda: solve_fn([1_000_000]),
            (1_000_000, 1)) \
        .add_scaling("N (array size, maxId = 1,000,000)",
            [100, 1_000, 10_000, 50_000, 100_000, 200_000],
            lambda n: _gen(n, 1_000_000),
            lambda inp: solve_fn(inp),
            lambda inp: _brute_force(inp)) \
        .add_random_tests("Stress test (N=1..500, maxId=1..100)", 1_000,
            lambda: (
                lambda n=stress_rng.randint(1, 500), mx=stress_rng.randint(1, 100):
                    (lambda inp=_gen(n, mx, stress_rng.randint(0, 10**6)):
                        Case(f"N={n} maxId={mx}", lambda i=inp: solve_fn(i[:]), _brute_force(inp))
                    )()
            )()) \
        .add_benchmark("Large random (N = 200,000)",
            lambda: solve_fn(large_input[:]))


# ── Reference solution ───────────────────────────────────

def _brute_force(sightings):
    counts = Counter(sightings)
    best_id, best_freq = -1, 0
    for id_, freq in counts.items():
        if freq > best_freq or (freq == best_freq and id_ < best_id):
            best_id, best_freq = id_, freq
    return (best_id, best_freq)


# ── Input generators ─────────────────────────────────────

def _gen(n, max_id, seed=42):
    rng = random.Random(seed)
    return [rng.randint(1, max_id) for _ in range(n)]
