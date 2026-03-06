import java.util.*;
import java.util.function.*;

/**
 * Test infrastructure for Problem 2 — Two Sum (Bounded Values).
 * Contains reference solution, input generators, and all test cases.
 */
class Question2_Tests {

    static TestHarness<Boolean> buildHarness(BiFunction<int[], Integer, Boolean> solveFn) {
        Random rng = new Random(123);
        int[] largeInput = generateRandomInput(5_000_000, -100_000, 100_000, 42);

        return TestHarness.<Boolean>forProblem("Two Sum (Bounded Values)")

            // ── Correctness tests ────────────────────────────
            .addTest("Pair exists (endpoints)",
                () -> solveFn.apply(new int[]{1, 3, 5, 7}, 8),
                true)

            .addTest("Pair exists (middle)",
                () -> solveFn.apply(new int[]{2, 4, 6, 8}, 10),
                true)

            .addTest("No pair",
                () -> solveFn.apply(new int[]{1, 2, 3}, 10),
                false)

            .addTest("Negative numbers",
                () -> solveFn.apply(new int[]{-5, 3, 2, 10}, -2),
                true)

            .addTest("Duplicate needed",
                () -> solveFn.apply(new int[]{4, 4}, 8),
                true)

            .addTest("Single element can't pair with itself",
                () -> solveFn.apply(new int[]{5}, 10),
                false)

            .addTest("Zeros",
                () -> solveFn.apply(new int[]{0, 0, 1}, 0),
                true)

            .addTest("Boundary values",
                () -> solveFn.apply(new int[]{-100_000, 100_000}, 0),
                true)

            .addTest("Edge: target at boundary",
                () -> solveFn.apply(new int[]{100_000, 100_000}, 200_000),
                true)

            .addTest("Edge: negative target at boundary",
                () -> solveFn.apply(new int[]{-100_000, -100_000}, -200_000),
                true)

            .addTest("Edge: single element",
                () -> solveFn.apply(new int[]{42}, 84),
                false)

            // ── Scaling analysis ─────────────────────────────
            .addScaling("N (array size, values in [-1000..1000])",
                new int[]{100, 500, 1_000, 5_000, 10_000},
                n -> generateRandomInput(n, -1_000, 1_000, 42),
                input -> solveFn.apply(input, 42),
                input -> bruteForce(input, 42))

            // ── Random stress tests ──────────────────────────
            .addRandomTests("Stress test (N=1..50, values in [-20..20])", 1_000, () -> {
                int n = rng.nextInt(50) + 1;
                int[] a = generateRandomInput(n, -20, 20, rng.nextInt());
                int target = rng.nextInt(81) - 40;  // [-40..40]
                boolean expected = bruteForce(a, target);
                return new TestHarness.Case<>(
                    "N=" + n + " target=" + target,
                    () -> solveFn.apply(a.clone(), target),
                    expected);
            })

            // ── Benchmark ────────────────────────────────────
            .addBenchmark("Large random (N = 5,000,000)",
                () -> solveFn.apply(largeInput.clone(), 42));
    }

    // ── Reference solution ───────────────────────────────────

    private static boolean bruteForce(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] + A[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // ── Input generators ─────────────────────────────────────

    private static int[] generateRandomInput(int n, int lo, int hi, int seed) {
        Random rng = new Random(seed);
        int range = hi - lo + 1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rng.nextInt(range) + lo;
        }
        return arr;
    }
}
