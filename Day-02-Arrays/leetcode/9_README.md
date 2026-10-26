# LeetCode 69 — Sqrt(x)

## 📌 Problem Statement

Given a non-negative integer `x`, return the square root of `x` rounded down to the nearest integer.

You must not use built-in exponent functions or `Math.sqrt()`.

## 💡 Approach: Binary Search

Instead of checking every number one by one, binary search reduces the search range by half in each iteration.

### Steps

1. Initialize `left = 0`, `right = x`, and `answer = 0`.
2. Calculate the middle value using `mid = left + (right - left) / 2`.
3. Calculate `mid * mid` using `long` to avoid integer overflow.
4. If `mid * mid == x`, return `mid`.
5. If `mid * mid < x`, save `mid` as a possible answer and search the right half.
6. If `mid * mid > x`, search the left half.
7. When the search ends, return `answer`.

## 💻 Java Solution

```java
class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
```

## 🧪 Examples

**Example 1**

Input: `x = 4`

Output: `2`

Explanation: `2 × 2 = 4`.

**Example 2**

Input: `x = 8`

Output: `2`

Explanation: The square root of 8 is approximately 2.828. Rounding down gives 2.

**Example 3**

Input: `x = 30`

Output: `5`

Explanation: `5 × 5 = 25`, while `6 × 6 = 36`. Therefore, the integer square root is 5.

**Example 4**

Input: `x = 0`

Output: `0`

## 🔍 Why Use `long`?

An `int` can store values up to `2,147,483,647`. Multiplying a large `mid` by itself can exceed this limit.

Using `(long) mid * mid` converts `mid` to `long` before multiplication, preventing integer overflow.

## ⏱️ Complexity Analysis

- **Time Complexity:** `O(log x)` — the search range is halved in every iteration.
- **Space Complexity:** `O(1)` — only a constant number of variables are used.

## 📚 Key Learnings

- Applying binary search to a numerical problem.
- Eliminating half of the search range using comparisons.
- Finding the largest integer whose square is less than or equal to `x`.
- Using an `answer` variable to store the best valid result.
- Preventing integer overflow with `long`.

## 🔄 Brute Force vs. Binary Search

| Approach | Time Complexity |
|---|---|
| Brute force | `O(√x)` |
| Binary search | `O(log x)` |

Binary search is more efficient because it eliminates half of the remaining possibilities in each iteration.

## ✅ Progress

- [x] Problem solved
- [x] Binary search logic understood
- [x] Dry run completed
- [x] Integer overflow understood
- [x] Complexity analyzed
