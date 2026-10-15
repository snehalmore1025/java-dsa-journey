# LeetCode 1 — Two Sum

## Problem Details
- **Problem Number:** 1
- **Difficulty:** Easy
- **Topic:** Array
- **Language:** Java
- **Approach:** Brute Force

## Problem Statement
Given an integer array `nums` and an integer `target`, return the indices of two distinct elements whose sum equals `target`.

## Example
**Input:**
```text
nums = [2, 7, 11, 15]
target = 9
```

**Output:**
```text
[0, 1]
```

**Explanation:** `nums[0] + nums[1] = 2 + 7 = 9`.

## Approach
1. Use the outer loop to select the first element.
2. Store its value in `temp`.
3. Use the inner loop starting at `i + 1` to check the elements after it.
4. Calculate `temp + nums[j]`.
5. If the sum equals `target`, return the indices `{i, j}`.
6. If no pair is found, return an empty array.

## Code Explanation

- `i` selects the first element's index.
- `temp = nums[i]` stores the first element's value.
- `j = i + 1` starts checking from the next index.
- `sum = temp + nums[j]` calculates the sum of the pair.
- `if (sum == target)` checks whether the pair matches the target.
- `return new int[]{i, j}` returns the two indices.

### Why does `j` start at `i + 1`?

It prevents using the same element twice and avoids checking the same pair in reverse order. For example, after checking `(0, 1)`, we don't need to check `(1, 0)`.

## Dry Run

**Input:** `nums = [2, 7, 11, 15]`, `target = 9`

| Step | `i` | `temp` | `j` | `nums[j]` | Sum | Action |
|---:|---:|---:|---:|---:|---:|---|
| 1 | 0 | 2 | 1 | 7 | 9 | Match found; return `[0, 1]` |

The program stops as soon as the matching pair is found.

### What if the first pair doesn't match?

For `nums = [2, 7, 11, 15]` and `target = 20`:

| Step | `i` | `temp` | `j` | `nums[j]` | Sum | Action |
|---:|---:|---:|---:|---:|---:|---|
| 1 | 0 | 2 | 1 | 7 | 9 | Continue |
| 2 | 0 | 2 | 2 | 11 | 13 | Continue |
| 3 | 0 | 2 | 3 | 15 | 17 | Continue |
| 4 | 1 | 7 | 2 | 11 | 18 | Continue |
| 5 | 1 | 7 | 3 | 15 | 22 | Continue |
| 6 | 2 | 11 | 3 | 15 | 26 | No match |

No pair sums to `20`, so the method returns an empty array. This second example illustrates the worst-case search.

## Complexity Analysis

### Time Complexity: O(n²)
- The outer loop can visit up to `n` elements.
- For each element, the inner loop checks the remaining elements.
- In the worst case, the number of comparisons is `n(n - 1) / 2`.
- Ignoring constants and lower-order terms gives **O(n²)**.

### Auxiliary Space Complexity: O(1)
- The variables `i`, `j`, `temp`, and `sum` use constant extra space.
- The returned array always contains two indices, so its size is constant.

## What I Learned
- How nested loops check pairs of array elements.
- The difference between array values and their indices.
- Why the inner loop starts at `i + 1`.
- How to derive time and auxiliary space complexity.

## Optimization
A HashMap-based solution can improve the average time complexity to **O(n)**, using **O(n)** auxiliary space. This will be studied separately.

## Status
- [x] Brute-force solution implemented
- [x] Dry run completed
- [x] Complexity analysed
- [ ] Optimized HashMap solution
