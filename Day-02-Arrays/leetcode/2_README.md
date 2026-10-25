# LeetCode 704 — Binary Search

**Difficulty:** Easy  
**Topic:** Arrays, Binary Search  
**Language:** Java  
**Time Complexity:** O(log n)  
**Auxiliary Space Complexity:** O(1)

## Problem Statement

Given an array of integers `nums` sorted in ascending order and an integer `target`, return the index of `target` if it exists in the array. Otherwise, return `-1`.

The algorithm must run in **O(log n)** time complexity.

## Example 1

**Input:**
```text
nums = [-1, 0, 3, 5, 9, 12]
target = 9
```

**Output:**
```text
4
```

**Explanation:** The target `9` is present at index `4`.

## Example 2

**Input:**
```text
nums = [-1, 0, 3, 5, 9, 12]
target = 2
```

**Output:**
```text
-1
```

**Explanation:** The target `2` does not exist in the array.

## Approach: Binary Search

Binary search works on a sorted array by repeatedly reducing the search range by half.

1. Initialize `left = 0` and `right = nums.length - 1`.
2. Calculate the middle index using `left + (right - left) / 2`.
3. If `nums[mid] == target`, return `mid`.
4. If `nums[mid] > target`, move the right boundary to `mid - 1`.
5. If `nums[mid] < target`, move the left boundary to `mid + 1`.
6. Repeat while `left <= right`.
7. If the target is not found, return `-1`.

## Java Solution

```java
class Solution {
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
```

## Dry Run

**Input:** `nums = [-1, 0, 3, 5, 9, 12]`, `target = 9`

| Step | Left | Right | Mid | `nums[mid]` | Action |
|---|---:|---:|---:|---:|---|
| 1 | 0 | 5 | 2 | 3 | `3 < 9`, set `left = 3` |
| 2 | 3 | 5 | 4 | 9 | Target found; return `4` |

**Output:** `4`

## Complexity Analysis

### Time Complexity: O(log n)

Each iteration eliminates approximately half of the remaining search range. Therefore, the number of iterations grows logarithmically with the array size.

### Auxiliary Space Complexity: O(1)

The algorithm uses only a fixed number of variables: `left`, `right`, and `mid`. It does not create another array or use additional data structures.

## Key Learnings

- Binary search requires a sorted array.
- Array indexing starts at `0`.
- Recalculate `mid` after every pointer update.
- If the middle element is too large, move `right` left.
- If the middle element is too small, move `left` right.
- Return `-1` when the target is absent.
- Correct pointer updates prevent infinite loops and Time Limit Exceeded errors.

## Status

- [x] Problem solved
- [x] Binary search implemented
- [x] Dry run completed
- [x] Time and space complexity analyzed
