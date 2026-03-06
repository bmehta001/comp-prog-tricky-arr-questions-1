# Competitive Programming: Tricky Array Questions

A set of competitive programming problems that require using arrays in clever ways
for maximum optimization. Each problem has starter code with a single `solve()` function
for you to implement, plus a testing harness that checks correctness and benchmarks performance.

---

## Rule of Thumb: Array vs Dictionary

**Prefer an array when:**
- ✅ Keys are integers
- ✅ Keys fall in a known bounded range
- ✅ Range is dense enough and memory is acceptable (related adv. of better cache locality)
- ✅ You care about maximum speed (tight loops, large N)
- ✅ Want to avoid hashing cost, collision resolution, per-entry allocation overhead

**Prefer a dictionary/hash map when:**
- ✅ Keys are sparse/unknown/unbounded
- ✅ Keys are strings or composite objects
- ✅ Range is enormous (e.g., up to 1e18)
- ✅ Memory usage from a large array would be wasteful

---

## Problems

| # | Problem | Key Insight |
|---|---------|-------------|
| 1 | **Cow Sighting Frequency** — Find the most frequent ID | Counting array over bounded ID range |
| 2 | **Two Sum (Bounded Values)** — Check if any pair sums to target | Boolean seen-array instead of HashSet |
| 3 | **Largest K With Its Negative** — Find largest k where −k exists | Boolean presence array over small value range |

---

## How to Run

### Java
```bash
cd java
javac *.java
java Question1_CowSightings
java Question2_TwoSumBounded
java Question3_LargestKWithNegative
```

### Python
```bash
cd python
python question1_cow_sightings.py
python question2_two_sum_bounded.py
python question3_largest_k_with_negative.py
```

### C++
```bash
cd cpp
# MSVC
cl /std:c++17 /EHsc /O2 question1_cow_sightings.cpp /Fe:q1.exe && q1.exe

# GCC / Clang
g++ -std=c++17 -O2 question1_cow_sightings.cpp -o q1 && ./q1
```

Each question runs its own correctness tests and performance benchmarks.
Add your own test cases in each file's `main()` method (or `if __name__` block for Python).

---

## Project Structure

```
java/
  TestHarness.java                         # Generic testing & benchmarking harness
  Question1_CowSightings.java              # Problem 1 starter code (edit solve() here)
  Question2_TwoSumBounded.java             # Problem 2 starter code (edit solve() here)
  Question3_LargestKWithNegative.java      # Problem 3 starter code (edit solve() here)
  Question1_Tests.java                     # Problem 1 test cases & reference solution
  Question2_Tests.java                     # Problem 2 test cases & reference solution
  Question3_Tests.java                     # Problem 3 test cases & reference solution

python/
  test_harness.py                           # Testing & benchmarking harness
  question1_cow_sightings.py                # Problem 1 starter code (edit solve() here)
  question2_two_sum_bounded.py              # Problem 2 starter code (edit solve() here)
  question3_largest_k_with_negative.py      # Problem 3 starter code (edit solve() here)
  question1_tests.py                        # Problem 1 test cases & reference solution
  question2_tests.py                        # Problem 2 test cases & reference solution
  question3_tests.py                        # Problem 3 test cases & reference solution

cpp/
  test_harness.h                            # Header-only testing & benchmarking harness
  question1_cow_sightings.cpp               # Problem 1 starter code (edit solve() here)
  question2_two_sum_bounded.cpp             # Problem 2 starter code (edit solve() here)
  question3_largest_k_with_negative.cpp     # Problem 3 starter code (edit solve() here)
  question1_tests.h                         # Problem 1 test cases & reference solution
  question2_tests.h                         # Problem 2 test cases & reference solution
  question3_tests.h                         # Problem 3 test cases & reference solution
  CMakeLists.txt                            # CMake build file (optional)
```
