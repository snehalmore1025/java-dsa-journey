# LeetCode 33 — Search in Rotated Sorted Array

## Problem Statement

You are given an integer array `nums` that was originally sorted in ascending order and then rotated at an unknown pivot.

Given a target value, return its index if it exists in the array. Otherwise, return `-1`.

The solution must run in `O(log n)` time.

**LeetCode:** [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

## Example

**Input:**
```java
nums = [4, 5, 6, 7, 0, 1, 2]
target = 0
```

**Output:**
```java
4
```

**Explanation:** The target `0` is located at index `4`.

## Approach: Modified Binary Search

Although the complete array is rotated and not fully sorted, at least one half of the current search range is sorted.

1. Initialize `left = 0` and `right = nums.length - 1`.
2. Calculate the middle index using `left + (right - left) / 2`.
3. If `nums[mid] == target`, return `mid`.
4. If `nums[left] <= nums[mid]`, the left half is sorted:
   - If the target lies between `nums[left]` and `nums[mid]`, search left by setting `right = mid - 1`.
   - Otherwise, search right by setting `left = mid + 1`.
5. Otherwise, the right half is sorted:
   - If the target lies between `nums[mid]` and `nums[right]`, search right by setting `left = mid + 1`.
   - Otherwise, search left by setting `right = mid - 1`.
6. If the target is not found, return `-1`.

## Java Solution

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
```

## Dry Run

**Input:**
```java
nums = [4, 5, 6, 7, 0, 1, 2]
target = 0
```

| Step | Left | Right | Mid | `nums[mid]` | Action |
|---|---:|---:|---:|---:|---|
| 1 | 0 | 6 | 3 | 7 | Left half is sorted, but target is outside it. Set `left = 4`. |
| 2 | 4 | 6 | 5 | 1 | Left half is sorted. Target is to its left. Set `right = 4`. |
| 3 | 4 | 4 | 4 | 0 | Target found. Return `4`. |

**Output:** `4`

## Complexity Analysis

- **Time Complexity:** `O(log n)` — each iteration eliminates approximately half of the search range.
- **Auxiliary Space Complexity:** `O(1)` — only a constant number of variables are used.

## Key Learnings

- A rotated sorted array is not globally sorted, but at least one half of the current search range is sorted.
- Identify the sorted half before deciding which part to eliminate.
- Compare the target with the boundaries of the sorted half.
- Return the target's index if found; otherwise, return `-1`.
