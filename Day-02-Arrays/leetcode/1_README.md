# LeetCode 35 — Search Insert Position

**Difficulty:** Easy  
**Topic:** Arrays, Binary Search  
**Language:** Java  
**Time Complexity:** O(log n)  
**Space Complexity:** O(1)

## Problem Statement

Given a sorted array of distinct integers and a target value, return the index if the target is found. If the target is not found, return the index where it would be inserted to maintain the sorted order.

The algorithm must run in **O(log n)** time complexity.

## Examples

### Example 1

**Input:**
```text
nums = [1, 3, 5, 6], target = 5
```

**Output:**
```text
2
```

**Explanation:** The target `5` exists at index `2`.

### Example 2

**Input:**
```text
nums = [1, 3, 5, 6], target = 2
```

**Output:**
```text
1
```

**Explanation:** The target `2` should be inserted between `1` and `3`, at index `1`.

### Example 3

**Input:**
```text
nums = [1, 3, 5, 6], target = 7
```

**Output:**
```text
4
```

**Explanation:** The target belongs at the end of the array. Since the array has four elements, the insertion index is `4`.

## Approach: Binary Search

Binary search efficiently searches a sorted array by repeatedly reducing the search range by approximately half.

1. Initialize `left = 0` and `right = nums.length - 1`.
2. Calculate the middle index using `left + (right - left) / 2`.
3. If `nums[mid] == target`, return `mid`.
4. If `nums[mid] > target`, move the right boundary to `mid - 1`.
5. If `nums[mid] < target`, move the left boundary to `mid + 1`.
6. Repeat while `left <= right`.
7. If the target is not found, return `left`, which is the correct insertion index.

## Java Solution

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

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

        return left;
    }
}
```

## Dry Run

**Input:** `nums = [1, 3, 5, 6]`, `target = 4`

| Step | Left | Right | Mid | nums[mid] | Action |
|---|---:|---:|---:|---:|---|
| 1 | 0 | 3 | 1 | 3 | `3 < 4`, update left to 2 |
| 2 | 2 | 3 | 2 | 5 | `5 > 4`, update right to 1 |
| End | 2 | 1 | — | — | Loop ends; return left = 2 |

**Output:** `2`

The target `4` is absent, but index `2` is where it belongs to preserve sorted order.

## Complexity Analysis

### Time Complexity: O(log n)

Each iteration eliminates approximately half of the remaining search range. Therefore, the number of iterations grows logarithmically with the array size.

### Auxiliary Space Complexity: O(1)

The algorithm uses only a fixed number of variables: `left`, `right`, and `mid`. It does not create another array or use additional data structures.

## Key Learnings

- Binary search requires sorted data.
- Java integer division discards the fractional part.
- When `nums[mid] > target`, update `right`.
- When `nums[mid] < target`, update `left`.
- Return the index `mid` when the target is found.
- Return `left` when the target is absent.
- Incorrect pointer updates can cause an infinite loop and Time Limit Exceeded (TLE).

## Status

- [x] Problem solved
- [x] Binary search implemented
- [x] Dry run completed
- [x] Time and space complexity analyzed
