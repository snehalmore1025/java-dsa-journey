# LeetCode 153 — Find Minimum in Rotated Sorted Array

## Problem Statement

Given an array of distinct integers that was originally sorted in ascending order and then rotated, find and return the minimum element.

The solution must run in `O(log n)` time.

**LeetCode:** [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

## Example

**Input:**
```java
nums = [4, 5, 6, 7, 0, 1, 2]
```

**Output:**
```java
0
```

**Explanation:** The minimum element in the rotated sorted array is `0`.

## Approach: Binary Search

We use binary search to determine which half contains the minimum element.

1. Initialize `left = 0` and `right = nums.length - 1`.
2. Calculate `mid = left + (right - left) / 2`.
3. If `nums[mid] > nums[right]`, the minimum is to the right of `mid`. Set `left = mid + 1`.
4. Otherwise, the minimum is at `mid` or to its left. Set `right = mid`.
5. Continue until `left == right`.
6. Return `nums[left]`.

We use `right = mid` instead of `right = mid - 1` because `mid` itself might be the minimum.

## Java Solution

```java
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
```

## Dry Run

**Input:** `nums = [4, 5, 6, 7, 0, 1, 2]`

| Step | Left | Right | Mid | `nums[mid]` | `nums[right]` | Action |
|---|---:|---:|---:|---:|---:|---|
| 1 | 0 | 6 | 3 | 7 | 2 | `7 > 2`, set `left = 4` |
| 2 | 4 | 6 | 5 | 1 | 2 | `1 <= 2`, set `right = 5` |
| 3 | 4 | 5 | 4 | 0 | 1 | `0 <= 1`, set `right = 4` |
| Stop | 4 | 4 | — | — | — | Return `nums[4] = 0` |

**Output:** `0`

## Complexity Analysis

- **Time Complexity:** `O(log n)` — the search range is approximately halved in each iteration.
- **Auxiliary Space Complexity:** `O(1)` — only a constant number of variables are used.

## Key Learnings

- Binary search can find the minimum in a rotated sorted array efficiently.
- Compare `nums[mid]` with `nums[right]` to decide which section contains the minimum.
- If `nums[mid] > nums[right]`, move `left` to `mid + 1`.
- Otherwise, keep `mid` in the search range by setting `right = mid`.
- When `left == right`, that index contains the minimum element.
