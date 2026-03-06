#pragma once
/**
 * Test infrastructure for Problem 2 -- Two Sum (Bounded Values).
 * Contains reference solution, input generators, and all test cases.
 */

#include "test_harness.h"
#include <vector>
#include <random>
#include <functional>

namespace q2_tests {

using InputType = std::vector<int>;
using SolveFn = std::function<bool(const InputType&, int)>;

// ── Reference solution ───────────────────────────────────

inline bool bruteForce(const InputType& A, int target) {
    for (size_t i = 0; i < A.size(); i++) {
        for (size_t j = i + 1; j < A.size(); j++) {
            if (A[i] + A[j] == target) {
                return true;
            }
        }
    }
    return false;
}

// ── Input generators ─────────────────────────────────────

inline InputType genInput(int n, int lo, int hi, int seed = 42) {
    std::mt19937 rng(seed);
    std::uniform_int_distribution<int> dist(lo, hi);
    InputType arr(n);
    for (int i = 0; i < n; i++) {
        arr[i] = dist(rng);
    }
    return arr;
}

// ── Harness builder ──────────────────────────────────────

inline harness::TestHarness<bool> newHarness() {
    return harness::TestHarness<bool>::forProblem("Two Sum (Bounded Values)");
}

inline harness::TestHarness<bool>& addTests(
        harness::TestHarness<bool>& h, SolveFn solveFn) {
    static std::mt19937 stressRng(123);
    static auto largeInput = genInput(5'000'000, -100'000, 100'000);

    using V = InputType;

    return h
        .addTest("Pair exists (endpoints)",
            [=](){ return solveFn({1, 3, 5, 7}, 8); },
            true)

        .addTest("Pair exists (middle)",
            [=](){ return solveFn({2, 4, 6, 8}, 10); },
            true)

        .addTest("No pair",
            [=](){ return solveFn({1, 2, 3}, 10); },
            false)

        .addTest("Negative numbers",
            [=](){ return solveFn({-5, 3, 2, 10}, -2); },
            true)

        .addTest("Duplicate needed",
            [=](){ return solveFn({4, 4}, 8); },
            true)

        .addTest("Single element can't pair with itself",
            [=](){ return solveFn({5}, 10); },
            false)

        .addTest("Zeros",
            [=](){ return solveFn({0, 0, 1}, 0); },
            true)

        .addTest("Boundary values",
            [=](){ return solveFn({-100'000, 100'000}, 0); },
            true)

        .addTest("Edge: target at boundary",
            [=](){ return solveFn({100'000, 100'000}, 200'000); },
            true)

        .addTest("Edge: negative target at boundary",
            [=](){ return solveFn({-100'000, -100'000}, -200'000); },
            true)

        .addTest("Edge: single element",
            [=](){ return solveFn({42}, 84); },
            false)

        .addScaling<V>("N (array size, values in [-1000..1000])",
            {100, 500, 1'000, 5'000, 10'000},
            std::function<V(int)>([](int n) -> V { return genInput(n, -1'000, 1'000); }),
            std::function<bool(const V&)>([=](const V& input) -> bool { return solveFn(input, 42); }),
            std::function<bool(const V&)>([](const V& input) -> bool { return bruteForce(input, 42); }))

        .addRandomTests("Stress test (N=1..50, values in [-20..20])", 1'000,
            [=]() mutable -> harness::Case<bool> {
                int n = std::uniform_int_distribution<int>(1, 50)(stressRng);
                int target = std::uniform_int_distribution<int>(-40, 40)(stressRng);
                auto a = genInput(n, -20, 20, stressRng());
                bool expected = bruteForce(a, target);
                return {
                    "N=" + std::to_string(n) + " target=" + std::to_string(target),
                    [=]() { return solveFn(a, target); },
                    expected
                };
            })

        .addBenchmark("Large random (N = 5,000,000)",
            [=](){ return solveFn(largeInput, 42); });
}

} // namespace q2_tests
