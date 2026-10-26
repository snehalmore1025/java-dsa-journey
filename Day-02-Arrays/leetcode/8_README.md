# LeetCode 367 — Valid Perfect Square

## 📌 Problem Statement

Given a positive integer `num`, return `true` if `num` is a perfect square; otherwise, return `false`.

A perfect square is an integer that can be expressed as the product of an integer multiplied by itself.

**Restriction:** Do not use built-in functions such as `Math.sqrt()`.

## 💡 Approach: Brute Force

I used a brute-force approach to check whether the given number is a perfect square.

### Steps

1. Start a loop with `i = 1`.
2. Calculate `i * i` for each iteration.
3. Compare the square with `num`.
4. If `i * i == num`, return `true`.
5. Continue while `i * i <= num`.
6. If no matching square is found, return `false`.

## 💻 Java Solution

```java
class Solution {
    public boolean isPerfectSquare(int num) {
        for (int i = 1; (long) i * i <= num; i++) {
            if ((long) i * i == num) {
                return true;
            }
        }

        return false;
    }
}
```

## 🔍 Why Use `long`?

In Java, an `int` can store values up to `2,147,483,647`. Squaring a large integer can exceed this limit and cause integer overflow.

The expression `(long) i * i` converts `i` to `long` before multiplication, allowing the multiplication to produce a larger result safely.

## 🧪 Examples

**Example 1**

Input: `num = 16`

Output: `true`

Explanation: `4 × 4 = 16`.

**Example 2**

Input: `num = 14`

Output: `false`

Explanation: No integer multiplied by itself equals `14`.

**Example 3**

Input: `num = 1`

Output: `true`

Explanation: `1 × 1 = 1`.

## ⏱️ Complexity Analysis

- **Time Complexity:** `O(√n)` — the loop checks integers only up to the square root of `num`.
- **Space Complexity:** `O(1)` — only a constant amount of extra space is used.

## 📚 Key Learnings

- Understanding brute-force problem solving.
- Checking perfect squares using multiplication.
- Using `long` to prevent integer overflow.
- Optimizing the loop by stopping when the square exceeds `num`.
- Handling the edge case `num = 1`.

## 🚀 Optimization

This brute-force solution can be improved using **binary search**, reducing the time complexity from `O(√n)` to `O(log n)`.

## ✅ Progress

- [x] Problem solved
- [x] Edge case handled
- [x] Integer overflow understood
- [x] Complexity analyzed
