# LeetCode 283 — Move Zeroes

**Difficulty:** Easy  
**Topic:** Arrays, Two Pointers  
**Language:** Java  
**Approach:** In-place traversal using two loops

## 1. Problem Statement

Given an integer array `nums`, move all `0`s to the end of the array while maintaining the relative order of all non-zero elements.

The operation must be performed **in-place**, without creating another array.

## 2. Example

**Input:**
```text
nums = [0, 1, 0, 3, 12]
```

**Output:**
```text
[1, 3, 12, 0, 0]
```

**Explanation:** All non-zero elements move to the beginning in their original order, and all zeroes move to the end.

## 3. Approach

I used two loops and a variable named `pos`.

- Initialize `pos = 0` to track the position where the next non-zero element should be placed.
- **First loop:** Traverse the array. Whenever `nums[i] != 0`, copy that value to `nums[pos]` and increment `pos`.
- **Second loop:** Starting from `pos`, fill all remaining positions with `0`.

This approach modifies the original array without creating another array.

## 4. Java Solution

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        for (int i = pos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
```

## 5. Code Explanation

| Code | Purpose |
|---|---|
| `int pos = 0;` | Stores the next position for a non-zero element. |
| `i < nums.length` | Traverses every element in the array. |
| `nums[i] != 0` | Checks whether the current element is non-zero. |
| `nums[pos] = nums[i];` | Copies the non-zero element to the next available position. |
| `pos++;` | Advances the position for the next non-zero element. |
| `for (int i = pos; ...)` | Starts at the first position after the non-zero elements. |
| `nums[i] = 0;` | Fills the remaining positions with zeroes. |

## 6. Dry Run

Input: `[0, 1, 0, 3, 12]`

### First loop — move non-zero elements

| `i` | `nums[i]` | Action | `pos` after action |
|---:|---:|---|---:|
| 0 | 0 | Skip | 0 |
| 1 | 1 | Set `nums[0] = 1` | 1 |
| 2 | 0 | Skip | 1 |
| 3 | 3 | Set `nums[1] = 3` | 2 |
| 4 | 12 | Set `nums[2] = 12` | 3 |

Array after the first loop:

```text
[1, 3, 12, 3, 12]
```

The last two positions still contain old values, so the second loop replaces them.

### Second loop — fill zeroes

| `i` | Action | Array |
|---:|---|---|
| 3 | Set `nums[3] = 0` | `[1, 3, 12, 0, 12]` |
| 4 | Set `nums[4] = 0` | `[1, 3, 12, 0, 0]` |

**Final output:** `[1, 3, 12, 0, 0]`

## 7. Complexity Analysis

- **Time Complexity:** `O(n)` — both loops take linear time, so their combined time remains linear.
- **Auxiliary Space Complexity:** `O(1)` — only a few variables are used; no additional array is created.

## 8. Key Learnings

- Use an index variable to track where an element should be written.
- Separate moving non-zero elements from filling the remaining positions.
- Two sequential loops can still have `O(n)` time complexity.
- In-place algorithms modify the original array instead of creating another array.

## 9. Common Mistakes

- Setting `pos = nums[i]` instead of copying the value into `nums[pos]`.
- Forgetting to increment `pos` after placing a non-zero element.
- Forgetting the second loop, which fills the remaining positions with zeroes.
- Creating another array when an in-place solution is required.

## 10. Practice Status

- [x] Implemented the two-loop approach.
- [x] Understood the purpose of `pos`.
- [x] Traced the example manually.
- [ ] Revisit and implement independently.

**LeetCode:** [283. Move Zeroes](https://leetcode.com/problems/move-zeroes/)
