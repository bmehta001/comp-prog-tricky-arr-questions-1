import java.util.*;
import java.util.function.*;

/**
 * Test infrastructure for Problem 1 — Cow Sighting Frequency.
 * Contains reference solution, input generators, and all test cases.
 */
class Question1_Tests {

    static TestHarness<int[]> buildHarness(Function<int[], int[]> solveFn) {
        Random rng = new Random(123);
        int[] largeInput = generateRandomInput(200_000, 1_000_000);

        return TestHarness.<int[]>forProblem("Cow Sighting Frequency")

            // ── Correctness tests ────────────────────────────
            .addTest("Basic test",
                () -> solveFn.apply(new int[]{1, 2, 1, 3, 1}),
                new int[]{1, 3})

            .addTest("Single element",
                () -> solveFn.apply(new int[]{5}),
                new int[]{5, 1})

            .addTest("All same",
                () -> solveFn.apply(new int[]{42, 42, 42}),
                new int[]{42, 3})

            .addTest("Tie \u2192 smallest ID wins",
                () -> solveFn.apply(new int[]{3, 3, 2, 2}),
                new int[]{2, 2})

            .addTest("Large IDs",
                () -> solveFn.apply(new int[]{999_999, 1_000_000, 999_999}),
                new int[]{999_999, 2})

            .addTest("Edge: two elements, different, ascending",
                () -> solveFn.apply(new int[]{1, 2}),
                new int[]{1, 1})

            .addTest("Edge: two elements, different, descending",
                () -> solveFn.apply(new int[]{2, 1}),
                new int[]{1, 1})

            .addTest("Edge: max ID only",
                () -> solveFn.apply(new int[]{1_000_000}),
                new int[]{1_000_000, 1})

            // ── Scaling analysis ─────────────────────────────
            .addScaling("N (array size, maxId = 1,000,000)",
                new int[]{100, 1_000, 10_000, 50_000, 100_000, 200_000},
                n -> generateRandomInput(n, 1_000_000),
                input -> solveFn.apply(input),
                input -> bruteForce(input))

            // ── Random stress tests ──────────────────────────
            .addRandomTests("Stress test (N=1..500, maxId=1..100)", 1_000, () -> {
                int n = rng.nextInt(500) + 1;
                int maxId = rng.nextInt(100) + 1;
                int[] input = generateRandomInput(n, maxId, rng.nextInt());
                int[] expected = bruteForce(input);
                return new TestHarness.Case<>(
                    "N=" + n + " maxId=" + maxId,
                    () -> solveFn.apply(input.clone()),
                    expected);
            })

            // ── Benchmark ────────────────────────────────────
            .addBenchmark("Large random (N = 200,000)",
                () -> solveFn.apply(largeInput.clone()));
    }

    // ── Reference solution ───────────────────────────────────

    private static int[] bruteForce(int[] sightings) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int id : sightings) {
            counts.merge(id, 1, Integer::sum);
        }
        int bestId = -1, bestFreq = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int id = entry.getKey(), freq = entry.getValue();
            if (freq > bestFreq || (freq == bestFreq && id < bestId)) {
                bestId = id;
                bestFreq = freq;
            }
        }
        return new int[]{bestId, bestFreq};
    }

    // ── Input generators ─────────────────────────────────────

    private static int[] generateRandomInput(int n, int maxId) {
        return generateRandomInput(n, maxId, 42);
    }

    private static int[] generateRandomInput(int n, int maxId, int seed) {
        Random rng = new Random(seed);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rng.nextInt(maxId) + 1;
        }
        return arr;
    }
}
