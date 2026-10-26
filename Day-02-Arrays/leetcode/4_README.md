# LeetCode 34 — Find First and Last Position of Element in Sorted Array

## Problem Statement

Given an integer array `nums` sorted in non-decreasing order, find the starting and ending positions of a given target value.

If the target is not found, return `[-1, -1]`.

**LeetCode:** [34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

## Example

**Input:**
```java
nums = [5, 7, 7, 8, 8, 8, 10]
target = 8
```

**Output:**
```java
[3, 5]
```

**Explanation:** The first occurrence of `8` is at index `3`, and the last occurrence is at index `5`.

## Approach: Binary Search

We perform binary search twice to achieve `O(log n)` time complexity.

1. **First binary search:** Find the first occurrence of the target. When the target is found, store its index in `first` and continue searching to the left using `right = mid - 1`.
2. **Second binary search:** Find the last occurrence of the target. When the target is found, store its index in `last` and continue searching to the right using `left = mid + 1`.
3. Return the result as `new int[]{first, last}`.

If the target is not found, the corresponding variable remains `-1`.

## Java Solution

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;

        // First binary search: find first occurrence
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Second binary search: find last occurrence
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{first, last};
    }
}
```

## Dry Run — First Occurrence

**Input:** `nums = [5, 7, 7, 8, 8, 8, 10]`, `target = 8`

| Step | Left | Right | Mid | Value | Action |
|---|---:|---:|---:|---:|---|
| 1 | 0 | 6 | 3 | 8 | Save `first = 3`; search left |
| 2 | 0 | 2 | 1 | 7 | Search right |
| 3 | 2 | 2 | 2 | 7 | Search right |
| Stop | 3 | 2 | — | — | Return `first = 3` |

## Dry Run — Last Occurrence

| Step | Left | Right | Mid | Value | Action |
|---|---:|---:|---:|---:|---|
| 1 | 0 | 6 | 3 | 8 | Save `last = 3`; search right |
| 2 | 4 | 6 | 5 | 8 | Update `last = 5`; search right |
| 3 | 6 | 6 | 6 | 10 | Search left |
| Stop | 6 | 5 | — | — | Return `last = 5` |

**Final output:** `[3, 5]`

## Complexity Analysis

- **Time Complexity:** `O(log n)` — two binary searches, each taking logarithmic time.
- **Auxiliary Space Complexity:** `O(1)` — only a constant number of variables are used.

## Key Learnings

- Binary search works efficiently because the array is sorted.
- To find the first occurrence, save the matching index and move left.
- To find the last occurrence, save the matching index and move right.
- When `nums[mid] < target`, move right using `left = mid + 1`.
- When `nums[mid] > target`, move left using `right = mid - 1`.
- Return `[-1, -1]` when the target does not exist.
