"""
===============================================================
 PROBLEM 3 -- Largest Positive Integer That Exists With Its Negative
===============================================================

 Given an integer array nums that does NOT contain any zeros,
 find the largest positive integer k such that -k also exists
 in the array.

 Return the positive integer k.
 If there is no such integer, return -1.

 Constraints:
   1 <= len(nums) <= 1000
   -1000 <= nums[i] <= 1000
   nums[i] != 0

 Examples:
   nums = [-1, 2, -3, 3]         ->  3
   nums = [-1, 10, 6, 7, -7, 1]  ->  7
   nums = [-10, 8, 6, 7, -2, -3] -> -1

 Hint: Values are bounded to [-1000..1000]. Can you use a
       list to track which values you've seen?

 Run:
   python question3_largest_k_with_negative.py
===============================================================
"""

import sys
from question3_tests import build_harness


def solve(nums: list[int]) -> int:
    """
    Implement this function.

    Args:
        nums: list of non-zero integers (each in [-1000..1000])
    Returns:
        the largest positive k where -k also exists, or -1
    """
    # TODO: Implement your solution here
    return -1


if __name__ == "__main__":
    passed = build_harness(solve) \
        .run()   # Tip: change to .run_quick() for faster feedback (skips benchmarks & scaling)
    # Add your own tests by chaining before .run():
    #   build_harness(solve) \
    #       .add_test("My test", lambda: solve([-3, 3]), 3) \
    #       .run()
    if not passed:
        sys.exit(1)
