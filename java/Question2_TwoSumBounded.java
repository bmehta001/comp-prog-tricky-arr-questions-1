/**
 * ═══════════════════════════════════════════════════════════
 *  PROBLEM 2 — Two Sum (Bounded Values)
 * ═══════════════════════════════════════════════════════════
 *
 *  Given an array A of length N, determine whether there exist
 *  distinct indices i != j such that:
 *
 *      A[i] + A[j] == target
 *
 *  Constraints:
 *    1 <= N      <= 5 * 10^6
 *    -100,000 <= A[i] <= 100,000
 *    -200,000 <= target <= 200,000
 *
 *  Return:
 *    true  if such a pair exists
 *    false otherwise
 *
 *  Examples:
 *    A = [1, 3, 5, 7], target = 8  ->  true   (1+7 or 3+5)
 *    A = [1, 2, 3],    target = 10 ->  false
 *
 *  Hint: Values are bounded to a small range. A HashSet works,
 *        but can you do better?
 *
 *  Compile & run:
 *    javac *.java
 *    java Question2_TwoSumBounded
 * ═══════════════════════════════════════════════════════════
 */
public class Question2_TwoSumBounded {

    /**
     * Implement this method.
     *
     * @param A      array of integers (each in [-100_000 .. 100_000])
     * @param target the target sum
     * @return true if any two distinct elements sum to target
     */
    public static boolean solve(int[] A, int target) {
        // TODO: Implement your solution here
        return false;
    }

    public static void main(String[] args) {
        boolean passed = Question2_Tests.buildHarness(Question2_TwoSumBounded::solve)
            // Add your own tests here:
            // .addTest("My test", () -> solve(new int[]{1,2}, 3), true)
            .run();   // Tip: change to .runQuick() for faster feedback (skips benchmarks & scaling)
        if (!passed) {
            System.exit(1);
        }
    }
}
