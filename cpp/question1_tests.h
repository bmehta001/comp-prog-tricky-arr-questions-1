#pragma once
/**
 * Test infrastructure for Problem 1 -- Cow Sighting Frequency.
 * Contains reference solution, input generators, and all test cases.
 */

#include "test_harness.h"
#include <vector>
#include <random>
#include <utility>
#include <unordered_map>
#include <functional>

namespace q1_tests {

using ResultType = std::pair<int, int>;
using InputType = std::vector<int>;
using SolveFn = std::function<ResultType(const InputType&)>;

// ── Reference solution ───────────────────────────────────

inline ResultType bruteForce(const InputType& sightings) {
    std::unordered_map<int, int> counts;
    for (int id : sightings) {
        counts[id]++;
    }
    int bestId = -1, bestFreq = 0;
    for (auto& [id, freq] : counts) {
        if (freq > bestFreq || (freq == bestFreq && id < bestId)) {
            bestId = id;
            bestFreq = freq;
        }
    }
    return {bestId, bestFreq};
}

// ── Input generators ─────────────────────────────────────

inline InputType genInput(int n, int maxId, int seed = 42) {
    std::mt19937 rng(seed);
    std::uniform_int_distribution<int> dist(1, maxId);
    InputType arr(n);
    for (int i = 0; i < n; i++) {
        arr[i] = dist(rng);
    }
    return arr;
}

// ── Harness builder ──────────────────────────────────────

inline harness::TestHarness<ResultType> newHarness() {
    return harness::TestHarness<ResultType>::forProblem("Cow Sighting Frequency");
}

inline harness::TestHarness<ResultType>& addTests(
        harness::TestHarness<ResultType>& h, SolveFn solveFn) {
    static std::mt19937 stressRng(123);
    static auto largeInput = genInput(200'000, 1'000'000);

    using P = ResultType;
    using V = InputType;

    return h
        .addTest("Basic test",
            [=](){ return solveFn({1, 2, 1, 3, 1}); },
            {1, 3})

        .addTest("Single element",
            [=](){ return solveFn({5}); },
            {5, 1})

        .addTest("All same",
            [=](){ return solveFn({42, 42, 42}); },
            {42, 3})

        .addTest("Tie -> smallest ID wins",
            [=](){ return solveFn({3, 3, 2, 2}); },
            {2, 2})

        .addTest("Large IDs",
            [=](){ return solveFn({999'999, 1'000'000, 999'999}); },
            {999'999, 2})

        .addTest("Edge: two elements, different, ascending",
            [=](){ return solveFn({1, 2}); },
            {1, 1})

        .addTest("Edge: two elements, different, descending",
            [=](){ return solveFn({2, 1}); },
            {1, 1})

        .addTest("Edge: max ID only",
            [=](){ return solveFn({1'000'000}); },
            {1'000'000, 1})

        .addScaling<V>("N (array size, maxId = 1,000,000)",
            {100, 1'000, 10'000, 50'000, 100'000, 200'000},
            std::function<V(int)>([](int n) -> V { return genInput(n, 1'000'000); }),
            std::function<P(const V&)>([=](const V& input) -> P { return solveFn(input); }),
            std::function<P(const V&)>([](const V& input) -> P { return bruteForce(input); }))

        .addRandomTests("Stress test (N=1..500, maxId=1..100)", 1'000,
            [=]() mutable -> harness::Case<P> {
                int n = std::uniform_int_distribution<int>(1, 500)(stressRng);
                int maxId = std::uniform_int_distribution<int>(1, 100)(stressRng);
                auto input = genInput(n, maxId, stressRng());
                auto expected = bruteForce(input);
                return {
                    "N=" + std::to_string(n) + " maxId=" + std::to_string(maxId),
                    [=]() { return solveFn(input); },
                    expected
                };
            })

        .addBenchmark("Large random (N = 200,000)",
            [=](){ return solveFn(largeInput); });
}

} // namespace q1_tests
