import java.util.*;
import java.util.function.*;

/**
 * Test infrastructure for Problem 3 — Largest K With Its Negative.
 * Contains reference solution, input generators, and all test cases.
 */
class Question3_Tests {

    static TestHarness<Integer> buildHarness(Function<int[], Integer> solveFn) {
        Random rng = new Random(123);
        int[] largeInput = generateRandomInput(1000, 42);

        return TestHarness.<Integer>forProblem("Largest K With Its Negative")

            // ── Correctness tests ────────────────────────────
            .addTest("Example 1",
                () -> solveFn.apply(new int[]{-1, 2, -3, 3}),
                3)

            .addTest("Example 2",
                () -> solveFn.apply(new int[]{-1, 10, 6, 7, -7, 1}),
                7)

            .addTest("Example 3 \u2014 no match",
                () -> solveFn.apply(new int[]{-10, 8, 6, 7, -2, -3}),
                -1)

            .addTest("All positives",
                () -> solveFn.apply(new int[]{1, 2, 3, 4}),
                -1)

            .addTest("All negatives",
                () -> solveFn.apply(new int[]{-1, -2, -3, -4}),
                -1)

            .addTest("Single pair",
                () -> solveFn.apply(new int[]{-5, 5}),
                5)

            .addTest("Multiple pairs \u2192 largest wins",
                () -> solveFn.apply(new int[]{-1, 1, -2, 2, -3, 3}),
                3)

            .addTest("Boundary values",
                () -> solveFn.apply(new int[]{-1000, 1000, -999, 999}),
                1000)

            .addTest("Edge: single element",
                () -> solveFn.apply(new int[]{7}),
                -1)

            .addTest("Edge: mirror pair at boundary",
                () -> solveFn.apply(new int[]{-1, 1}),
                1)

            // ── Scaling analysis ─────────────────────────────
            .addScaling("N (array size, values in [-1000..1000])",
                new int[]{10, 50, 100, 200, 500, 1_000},
                n -> generateRandomInput(n, 42),
                input -> solveFn.apply(input),
                input -> bruteForce(input))

            // ── Random stress tests ──────────────────────────
            .addRandomTests("Stress test (N=1..100, values in [-50..50])", 1_000, () -> {
                int n = rng.nextInt(100) + 1;
                int[] input = generateRandomInputBounded(n, 50, rng.nextInt());
                int expected = bruteForce(input);
                return new TestHarness.Case<>(
                    "N=" + n,
                    () -> solveFn.apply(input.clone()),
                    expected);
            })

            // ── Benchmark ────────────────────────────────────
            .addBenchmark("Random (N = 1,000)",
                () -> solveFn.apply(largeInput.clone()));
    }

    // ── Reference solution ───────────────────────────────────

    private static int bruteForce(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int v : nums) {
            seen.add(v);
        }
        int best = -1;
        for (int v : seen) {
            if (v > 0 && seen.contains(-v)) {
                best = Math.max(best, v);
            }
        }
        return best;
    }

    // ── Input generators ─────────────────────────────────────

    private static int[] generateRandomInput(int n, int seed) {
        return generateRandomInputBounded(n, 1000, seed);
    }

    private static int[] generateRandomInputBounded(int n, int maxAbs, int seed) {
        Random rng = new Random(seed);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int v = rng.nextInt(2 * maxAbs) - maxAbs;  // [-maxAbs, maxAbs-1]
            if (v >= 0) {
                v++;  // skip zero -> [1, maxAbs]
            }
            arr[i] = v;
        }
        return arr;
    }
}
