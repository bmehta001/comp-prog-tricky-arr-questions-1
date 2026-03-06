"""
===============================================================
 PROBLEM 1 -- Cow Sighting Frequency
===============================================================

 You're given N cow sightings. Each sighting contains an
 integer ID in the range [1 .. 1,000,000].

 Return the ID that appears most frequently and its frequency.
 If there is a tie, return the SMALLEST ID among the most frequent.

 Constraints:
   1 <= N  <= 2 * 10^5
   1 <= ID <= 10^6

 Return:
   A tuple (most_frequent_id, frequency)

 Example:
   sightings = [1, 2, 1, 3, 1]  ->  (1, 3)

 Hint: The ID range is bounded. Can you exploit that for O(N) time?

 Run:
   python question1_cow_sightings.py
===============================================================
"""

import sys
from question1_tests import build_harness


def solve(sightings: list[int]) -> tuple[int, int]:
    """
    Implement this function.

    Args:
        sightings: list of cow-sighting IDs (each in [1..1_000_000])
    Returns:
        (most_frequent_id, frequency)
    """
    # TODO: Implement your solution here
    return (-1, 0)


if __name__ == "__main__":
    passed = build_harness(solve) \
        .run()   # Tip: change to .run_quick() for faster feedback (skips benchmarks & scaling)
    # Add your own tests by chaining before .run():
    #   build_harness(solve) \
    #       .add_test("My test", lambda: solve([1,2,1]), (1, 2)) \
    #       .run()
    if not passed:
        sys.exit(1)
