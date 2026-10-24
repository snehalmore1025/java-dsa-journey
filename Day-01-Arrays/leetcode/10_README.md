# Day 1 — Problem 10: Concatenation of Array

**Platform:** LeetCode  
**Problem Number:** 1929  
**Topic:** Arrays  
**Difficulty:** Easy

## Problem Statement

Given an integer array `nums` of length `n`, create an array `ans` of length `2n` such that:

- `ans[i] = nums[i]`
- `ans[i + n] = nums[i]`

In simple words, concatenate the array with itself.

## Example

**Input:**
```text
nums = [1, 2, 3]
```

**Output:**
```text
[1, 2, 3, 1, 2, 3]
```

## Approach

1. Create a new array `ans` of size `2 * nums.length`.
2. Traverse the original array using a `for` loop.
3. Copy each element into the same index in `ans`.
4. Copy the same element again at index `i + nums.length`.
5. Return the resulting array.

## Java Solution

```java
class Solution {
    public int[] getConcatenation(int[] nums) {
        int ans[] = new int[2 * nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }

        return ans;
    }
}
```

## Dry Run

Input: `nums = [1, 2, 3]`

The original array has 3 elements, so the new array has 6 elements.

| `i` | `nums[i]` | First assignment | Second assignment | `ans` after iteration |
|---:|---:|---|---|---|
| 0 | 1 | `ans[0] = 1` | `ans[3] = 1` | `[1, 0, 0, 1, 0, 0]` |
| 1 | 2 | `ans[1] = 2` | `ans[4] = 2` | `[1, 2, 0, 1, 2, 0]` |
| 2 | 3 | `ans[2] = 3` | `ans[5] = 3` | `[1, 2, 3, 1, 2, 3]` |

**Final Output:** `[1, 2, 3, 1, 2, 3]`

## Complexity Analysis

- **Time Complexity:** `O(n)` — the loop runs `n` times, performing constant-time assignments in each iteration.
- **Space Complexity:** `O(n)` — a new array of size `2n` is created.

## Key Learning

- Array indices start at `0`.
- `nums.length` gives the number of elements in the array.
- `ans[i]` copies an element into the first half.
- `ans[i + nums.length]` copies it into the second half.
- A single loop can perform both copying operations.

## Status

- [x] Problem solved
- [x] Dry run completed
- [x] Time and space complexity understood
