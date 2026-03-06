/**
 * ═══════════════════════════════════════════════════════════
 *  PROBLEM 1 — Cow Sighting Frequency
 * ═══════════════════════════════════════════════════════════
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
 *    int[] of length 2 → { mostFrequentID, frequency }
 *
 *  Example:
 *    sightings = [1, 2, 1, 3, 1]  →  [1, 3]
 *
 *  Hint: The ID range is bounded. Can you exploit that for O(N) time?
 *
 *  Compile & run:
 *    javac *.java
 *    java Question1_CowSightings
 * ═══════════════════════════════════════════════════════════
 */
public class Question1_CowSightings {

    /**
     * Implement this method.
     *
     * @param sightings  array of cow-sighting IDs (each in [1..1_000_000])
     * @return int[2] → {mostFrequentID, frequency}
     */
    public static int[] solve(int[] sightings) {
        // TODO: Implement your solution here
        return new int[]{-1, 0};
    }

    public static void main(String[] args) {
        boolean passed = Question1_Tests.buildHarness(Question1_CowSightings::solve)
            // Add your own tests here:
            // .addTest("My test", () -> solve(new int[]{1,2,1}), new int[]{1, 2})
            .run();   // Tip: change to .runQuick() for faster feedback (skips benchmarks & scaling)
        if (!passed) {
            System.exit(1);
        }
    }
}
