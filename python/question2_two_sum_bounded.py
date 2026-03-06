"""
===============================================================
 PROBLEM 2 -- Two Sum (Bounded Values)
===============================================================

 Given an array A of length N, determine whether there exist
 distinct indices i != j such that:

     A[i] + A[j] == target

 Constraints:
   1 <= N         <= 5 * 10^6
   -100,000 <= A[i]   <= 100,000
   -200,000 <= target  <= 200,000

 Return:
   True  if such a pair exists
   False otherwise

 Examples:
   A = [1, 3, 5, 7], target = 8  ->  True   (1+7 or 3+5)
   A = [1, 2, 3],    target = 10 ->  False

 Hint: Values are bounded to a small range. A set works,
       but can you do better with a plain boolean list?

 Run:
   python question2_two_sum_bounded.py
===============================================================
"""

import sys
from question2_tests import build_harness


def solve(A: list[int], target: int) -> bool:
    """
    Implement this function.

    Args:
        A:      list of integers (each in [-100_000 .. 100_000])
        target: the target sum
    Returns:
        True if any two distinct elements sum to target
    """
    # TODO: Implement your solution here
    return False


if __name__ == "__main__":
    passed = build_harness(solve) \
        .run()   # Tip: change to .run_quick() for faster feedback (skips benchmarks & scaling)
    # Add your own tests by chaining before .run():
    #   build_harness(solve) \
    #       .add_test("My test", lambda: solve([1,2], 3), True) \
    #       .run()
    if not passed:
        sys.exit(1)
