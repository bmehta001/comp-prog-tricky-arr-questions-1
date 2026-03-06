/**
 * ═══════════════════════════════════════════════════════════
 *  PROBLEM 3 — Largest Positive Integer That Exists With Its Negative
 * ═══════════════════════════════════════════════════════════
 *
 *  Adapted from LeetCode 2441:
 *  https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
 *
 *  Given an integer array nums that does NOT contain any zeros,
 *  find the largest positive integer k such that -k also exists
 *  in the array.
 *
 *  Return the positive integer k.
 *  If there is no such integer, return -1.
 *
 *  Constraints:
 *    1 <= nums.length <= 1000
 *    -1000 <= nums[i] <= 1000
 *    nums[i] != 0
 *
 *  Examples:
 *    nums = [-1, 2, -3, 3]         →  3
 *    nums = [-1, 10, 6, 7, -7, 1]  →  7
 *    nums = [-10, 8, 6, 7, -2, -3] → -1
 *
 *  Hint: Values are bounded to [-1000..1000]. Can you use an
 *        array to track which values you've seen?
 *
 *  Compile & run:
 *    javac *.java
 *    java Question3_LargestKWithNegative
 * ═══════════════════════════════════════════════════════════
 */
public class Question3_LargestKWithNegative {

    /**
     * Implement this method.
     *
     * @param nums  array of non-zero integers (each in [-1000..1000])
     * @return the largest positive k where -k also exists, or -1
     */
    public static int solve(int[] nums) {
        // TODO: Implement your solution here
        return -1;
    }

    public static void main(String[] args) {
        boolean passed = Question3_Tests.buildHarness(Question3_LargestKWithNegative::solve)
            // Add your own tests here:
            // .addTest("My test", () -> solve(new int[]{-3, 3}), 3)
            .run();   // Tip: change to .runQuick() for faster feedback (skips benchmarks & scaling)
        if (!passed) {
            System.exit(1);
        }
    }
}
