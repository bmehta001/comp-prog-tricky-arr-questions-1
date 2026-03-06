/**
 * ===============================================================
 *  PROBLEM 2 -- Two Sum (Bounded Values)
 * ===============================================================
 *
 *  Given an array A of length N, determine whether there exist
 *  distinct indices i != j such that:
 *
 *      A[i] + A[j] == target
 *
 *  Constraints:
 *    1 <= N         <= 5 * 10^6
 *    -100,000 <= A[i]   <= 100,000
 *    -200,000 <= target  <= 200,000
 *
 *  Return:
 *    true  if such a pair exists
 *    false otherwise
 *
 *  Examples:
 *    A = {1, 3, 5, 7}, target = 8  ->  true   (1+7 or 3+5)
 *    A = {1, 2, 3},    target = 10 ->  false
 *
 *  Hint: Values are bounded to a small range. An unordered_set works,
 *        but can you do better with a plain bool array?
 *
 *  Compile & run:
 *    g++ -std=c++17 -O2 question2_two_sum_bounded.cpp -o q2 && ./q2
 * ===============================================================
 */

#include "question2_tests.h"
#include <vector>

/**
 * Implement this function.
 *
 * @param A      vector of integers (each in [-100'000 .. 100'000])
 * @param target the target sum
 * @return true if any two distinct elements sum to target
 */
bool solve(const std::vector<int>& A, int target) {
    // TODO: Implement your solution here
    return false;
}

int main() {
    auto h = q2_tests::newHarness();
    bool passed = q2_tests::addTests(h, solve)
        // Add your own tests here:
        // .addTest("My test", [](){ return solve({1,2}, 3); }, true)
        .run();   // Tip: change to .runQuick() for faster feedback (skips benchmarks & scaling)
    return passed ? 0 : 1;
}
