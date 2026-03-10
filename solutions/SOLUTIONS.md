# Solution Key -- Array-Based Competitive Programming Questions
# These are the optimal O(N) solutions using arrays instead of hash maps.
# DO NOT commit this file to the student-facing repository.

## Question 1: Cow Sighting Frequency
IDs are in [1..1,000,000] -- use an array of size 1,000,001 as a frequency counter.
Then scan the array left-to-right so the first max found is the smallest ID (tie-breaker).

### Java
```java
public static int[] solve(int[] sightings) {
    int[] freq = new int[1_000_001];
    for (int id : sightings) freq[id]++;
    int bestId = -1, bestFreq = 0;
    for (int id = 1; id <= 1_000_000; id++) {
        if (freq[id] > bestFreq) {
            bestId = id;
            bestFreq = freq[id];
        }
    }
    return new int[]{bestId, bestFreq};
}
```

### Python
```python
def solve(sightings):
    freq = [0] * 1_000_001
    for id_ in sightings:
        freq[id_] += 1
    best_id, best_freq = -1, 0
    for id_ in range(1, 1_000_001):
        if freq[id_] > best_freq:
            best_id, best_freq = id_, freq[id_]
    return (best_id, best_freq)
```

### C++
```cpp
std::pair<int, int> solve(const std::vector<int>& sightings) {
    static int freq[1'000'001];
    std::fill(freq, freq + 1'000'001, 0);
    for (int id : sightings) freq[id]++;
    int bestId = -1, bestFreq = 0;
    for (int id = 1; id <= 1'000'000; id++) {
        if (freq[id] > bestFreq) {
            bestId = id;
            bestFreq = freq[id];
        }
    }
    return {bestId, bestFreq};
}
```

---

## Question 2: Two Sum (Bounded Values)
Values are in [-100,000..100,000] -- use a boolean array with offset 100,000.
For each element, check if (target - val) has been seen, then mark val as seen.

### Java
```java
public static boolean solve(int[] A, int target) {
    boolean[] seen = new boolean[200_001];
    int OFFSET = 100_000;
    for (int val : A) {
        int need = target - val;
        if (need >= -100_000 && need <= 100_000 && seen[need + OFFSET])
            return true;
        seen[val + OFFSET] = true;
    }
    return false;
}
```

### Python
```python
def solve(A, target):
    OFFSET = 100_000
    seen = [False] * 200_001
    for val in A:
        need = target - val
        if -100_000 <= need <= 100_000 and seen[need + OFFSET]:
            return True
        seen[val + OFFSET] = True
    return False
```

### C++
```cpp
bool solve(const std::vector<int>& A, int target) {
    constexpr int OFFSET = 100'000;
    static bool seen[200'001];
    std::fill(seen, seen + 200'001, false);
    for (int val : A) {
        int need = target - val;
        if (need >= -100'000 && need <= 100'000 && seen[need + OFFSET])
            return true;
        seen[val + OFFSET] = true;
    }
    return false;
}
```

---

## Question 3: Largest K With Its Negative
Values are in [-1000..1000] -- use a boolean array with offset 1000.
For each element, check if its negation has been seen. Track the max |v| of such pairs.

### Java
```java
public static int solve(int[] nums) {
    boolean[] seen = new boolean[2001];
    int OFFSET = 1000;
    int best = -1;
    for (int v : nums) {
        if (Math.abs(v) > best) {
            if (seen[-v + OFFSET]) {
                best = Math.abs(v);
            }
            seen[v + OFFSET] = true;
        }
    }
    return best;
}
```

### Python
```python
def solve(nums):
    OFFSET = 1000
    seen = [False] * 2001
    best = -1
    for v in nums:
        if abs(v) > best:
            if seen[-v + OFFSET]:
                best = abs(v)
            seen[v + OFFSET] = True
    return best
```

### C++
```cpp
int solve(const std::vector<int>& nums) {
    constexpr int OFFSET = 1000;
    bool seen[2001] = {};
    int best = -1;
    for (int v : nums) {
        if (std::abs(v) > best) {
            if (seen[-v + OFFSET]) {
                best = std::abs(v);
            }
            seen[v + OFFSET] = true;
        }
    }
    return best;
}
```
