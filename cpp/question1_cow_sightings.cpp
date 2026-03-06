/**
 * ===============================================================
 *  PROBLEM 1 -- Cow Sighting Frequency
 * ===============================================================
 *
 *  You're given N cow sightings. Each sighting contains an
 *  integer ID in the range [1 .. 1,000,000].
 *
 *  Return the ID that appears most frequently and its frequency.
 *  If there is a tie, return the SMALLEST ID among the most frequent.
 *
 *  Constraints:
 *    1 <= N  <= 2 * 10^5
 *    1 <= ID <= 10^6
 *
 *  Return:
 *    std::pair<int, int> -> {mostFrequentID, frequency}
 *
 *  Example:
 *    sightings = {1, 2, 1, 3, 1}  ->  {1, 3}
 *
 *  Hint: The ID range is bounded. Can you exploit that for O(N) time?
 *
 *  Compile & run:
 *    g++ -std=c++17 -O2 question1_cow_sightings.cpp -o q1 && ./q1
 * ===============================================================
 */

#include "question1_tests.h"
#include <vector>
#include <utility>

/**
 * Implement this function.
 *
 * @param sightings  vector of cow-sighting IDs (each in [1..1'000'000])
 * @return {mostFrequentID, frequency}
 */
std::pair<int, int> solve(const std::vector<int>& sightings) {
    // TODO: Implement your solution here
    return {-1, 0};
}

int main() {
    auto h = q1_tests::newHarness();
    bool passed = q1_tests::addTests(h, solve)
        // Add your own tests here:
        // .addTest("My test", [](){ return solve({1,2,1}); }, {1, 2})
        .run();   // Tip: change to .runQuick() for faster feedback (skips benchmarks & scaling)
    return passed ? 0 : 1;
}
