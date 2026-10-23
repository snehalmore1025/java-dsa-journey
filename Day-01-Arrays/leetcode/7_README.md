# Problem 7: Running Sum of 1d Array

**LeetCode:** [1480 — Running Sum of 1d Array](https://leetcode.com/problems/running-sum-of-1d-array/)  
**Topic:** Arrays  
**Difficulty:** Easy  
**Language:** Java

## Problem Statement

Given an array `nums`, return an array where each element is the sum of all elements from index `0` to that index.

### Example

**Input**
```text
nums = [1, 2, 3, 4]
```

**Output**
```text
[1, 3, 6, 10]
```

**Explanation**
- Index 0: `1`
- Index 1: `1 + 2 = 3`
- Index 2: `1 + 2 + 3 = 6`
- Index 3: `1 + 2 + 3 + 4 = 10`

## Approach: Running Total

1. Create a variable `result` and initialize it to `0`.
2. Create a new array `list` with the same length as `nums`.
3. Traverse the input array using a loop.
4. Add the current element to `result`.
5. Store `result` in `list[i]`.
6. Return `list`.

## Java Solution

```java
class Solution {
    public int[] runningSum(int[] nums) {
        int result = 0;
        int[] list = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
            list[i] = result;
        }

        return list;
    }
}
```

## Dry Run

Input: `[1, 2, 3, 4]`

| i | nums[i] | Running total | list |
|---|---:|---:|---|
| 0 | 1 | 1 | [1, 0, 0, 0] |
| 1 | 2 | 3 | [1, 3, 0, 0] |
| 2 | 3 | 6 | [1, 3, 6, 0] |
| 3 | 4 | 10 | [1, 3, 6, 10] |

## Complexity Analysis

- **Time Complexity:** O(n), because each element is visited once.
- **Auxiliary Space Complexity:** O(n), because a new result array is created.

## Concepts Learned

- Array declaration and initialization
- Array indexing
- `for` loops
- Accumulating a running total
- Storing values in an array
- Returning an array from a Java method

## Key Takeaway

The variable `result` maintains the cumulative sum, while `list[i]` stores the running sum at each index.
