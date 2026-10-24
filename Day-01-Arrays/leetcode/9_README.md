# Problem 9: Build Array from Permutation

**LeetCode:** [1920 — Build Array from Permutation](https://leetcode.com/problems/build-array-from-permutation/)  
**Topic:** Arrays, Indexing, Loops  
**Difficulty:** Easy  
**Language:** Java

## Problem Statement

Given an array `nums` of length `n`, create an array `ans` such that:

`ans[i] = nums[nums[i]]`

For each index `i`, use `nums[i]` as an index to access another element in `nums`, then store that value in `ans[i]`.

## Example

**Input**
```text
nums = [0, 2, 1, 5, 3, 4]
```

**Output**
```text
[0, 1, 2, 4, 5, 3]
```

## Approach

1. Create a new array `ans` of the same length as `nums`.
2. Traverse the array using a `for` loop.
3. Calculate `nums[nums[i]]` for each index.
4. Store the calculated value at `ans[i]`.
5. Return `ans`.

## Java Solution

```java
class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}
```

## Dry Run

Input: `[0, 2, 1, 5, 3, 4]`

| `i` | `nums[i]` | `nums[nums[i]]` | `ans` after assignment |
|---:|---:|---:|---|
| 0 | 0 | 0 | `[0, 0, 0, 0, 0, 0]` |
| 1 | 2 | 1 | `[0, 1, 0, 0, 0, 0]` |
| 2 | 1 | 2 | `[0, 1, 2, 0, 0, 0]` |
| 3 | 5 | 4 | `[0, 1, 2, 4, 0, 0]` |
| 4 | 3 | 5 | `[0, 1, 2, 4, 5, 0]` |
| 5 | 4 | 3 | `[0, 1, 2, 4, 5, 3]` |

**Final output:** `[0, 1, 2, 4, 5, 3]`

## Understanding `ans` vs. `ans[i]`

- `ans` refers to the entire array.
- `ans[i]` refers to the element at index `i`.
- `ans[i] = nums[nums[i]]` stores each calculated result at its correct position.
- `ans[]` without an index is invalid Java syntax for accessing an element.

## Complexity Analysis

- **Time Complexity:** `O(n)` — one loop processes each element once.
- **Auxiliary Space Complexity:** `O(n)` — a new array of length `n` is created.

## Key Takeaways

- Java arrays use zero-based indexing.
- A value from an array can be used as another array index.
- One loop is sufficient for this problem.
- Use `ans[i]` to store each result in its corresponding position.
