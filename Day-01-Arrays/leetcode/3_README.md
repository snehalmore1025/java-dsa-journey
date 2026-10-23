# LeetCode 217 — Contains Duplicate

## Problem
Given an integer array `nums`, return `true` if any value appears at least twice in the array. Return `false` if every element is distinct.

## Example
**Input:**
```text
nums = [1, 2, 3, 1]
```

**Output:**
```text
true
```

**Explanation:** The number `1` appears twice.

## Approach: Brute Force
- Use an outer loop to select each element.
- Store the current element in `temp`.
- Use an inner loop to compare it with every element that comes after it.
- If a matching element is found, return `true`.
- If no duplicates are found after checking all pairs, return `false`.

## Java Solution
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (temp == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

## Dry Run

Input: `[1, 2, 3, 1]`

| `i` | `temp` | `j` | Comparison | Result |
|---:|---:|---:|---|---|
| 0 | 1 | 1 | `1 == 2` | False |
| 0 | 1 | 2 | `1 == 3` | False |
| 0 | 1 | 3 | `1 == 1` | True |

Since a duplicate is found, the method returns `true` immediately.

## Complexity Analysis
- **Time Complexity:** `O(n²)` — nested loops compare pairs of elements.
- **Auxiliary Space:** `O(1)` — only a constant amount of extra space is used.

## Concepts Learned
- Array traversal
- Nested `for` loops
- Element comparison
- Boolean return values
- Brute-force problem solving

## Limitation
This approach may result in **Time Limit Exceeded (TLE)** for large inputs because it uses nested loops.

## Practice Status
- [x] Brute-force solution implemented
- [x] Dry run understood
- [ ] Optimized solution to be learned later
