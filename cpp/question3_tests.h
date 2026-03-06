#pragma once
/**
 * Test infrastructure for Problem 3 -- Largest K With Its Negative.
 * Contains reference solution, input generators, and all test cases.
 */

#include "test_harness.h"
#include <vector>
#include <random>
#include <unordered_set>
#include <functional>

namespace q3_tests {

using InputType = std::vector<int>;
using SolveFn = std::function<int(const InputType&)>;

// ── Reference solution ───────────────────────────────────

inline int bruteForce(const InputType& nums) {
    std::unordered_set<int> seen(nums.begin(), nums.end());
    int best = -1;
    for (int v : seen) {
        if (v > 0 && seen.count(-v)) {
            best = std::max(best, v);
        }
    }
    return best;
}

// ── Input generators ─────────────────────────────────────

inline InputType genInput(int n, int maxAbs, int seed = 42) {
    std::mt19937 rng(seed);
    std::uniform_int_distribution<int> dist(-maxAbs, maxAbs - 1);
    InputType arr(n);
    for (int i = 0; i < n; i++) {
        int v = dist(rng);
        if (v >= 0) {
            v++;  // skip zero
        }
        arr[i] = v;
    }
    return arr;
}

// ── Harness builder ──────────────────────────────────────

inline harness::TestHarness<int> newHarness() {
    return harness::TestHarness<int>::forProblem("Largest K With Its Negative");
}

inline harness::TestHarness<int>& addTests(
        harness::TestHarness<int>& h, SolveFn solveFn) {
    static std::mt19937 stressRng(123);
    static auto largeInput = genInput(1000, 1000);

    using V = InputType;

    return h
        .addTest("Example 1",
            [=](){ return solveFn({-1, 2, -3, 3}); },
            3)

        .addTest("Example 2",
            [=](){ return solveFn({-1, 10, 6, 7, -7, 1}); },
            7)

        .addTest("Example 3 - no match",
            [=](){ return solveFn({-10, 8, 6, 7, -2, -3}); },
            -1)

        .addTest("All positives",
            [=](){ return solveFn({1, 2, 3, 4}); },
            -1)

        .addTest("All negatives",
            [=](){ return solveFn({-1, -2, -3, -4}); },
            -1)

        .addTest("Single pair",
            [=](){ return solveFn({-5, 5}); },
            5)

        .addTest("Multiple pairs -> largest wins",
            [=](){ return solveFn({-1, 1, -2, 2, -3, 3}); },
            3)

        .addTest("Boundary values",
            [=](){ return solveFn({-1000, 1000, -999, 999}); },
            1000)

        .addTest("Edge: single element",
            [=](){ return solveFn({7}); },
            -1)

        .addTest("Edge: mirror pair at boundary",
            [=](){ return solveFn({-1, 1}); },
            1)

        .addScaling<V>("N (array size, values in [-1000..1000])",
            {10, 50, 100, 200, 500, 1000},
            std::function<V(int)>([](int n) -> V { return genInput(n, 1000); }),
            std::function<int(const V&)>([=](const V& input) -> int { return solveFn(input); }),
            std::function<int(const V&)>([](const V& input) -> int { return bruteForce(input); }))

        .addRandomTests("Stress test (N=1..100, values in [-50..50])", 1'000,
            [=]() mutable -> harness::Case<int> {
                int n = std::uniform_int_distribution<int>(1, 100)(stressRng);
                auto input = genInput(n, 50, stressRng());
                int expected = bruteForce(input);
                return {
                    "N=" + std::to_string(n),
                    [=]() { return solveFn(input); },
                    expected
                };
            })

        .addBenchmark("Random (N = 1,000)",
            [=](){ return solveFn(largeInput); });
}

} // namespace q3_tests
