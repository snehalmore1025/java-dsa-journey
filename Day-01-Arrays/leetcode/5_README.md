# LeetCode 485 — Max Consecutive Ones

## Problem
Given a binary array `nums`, return the maximum number of consecutive `1`s in the array.

## Example

**Input:**
```text
nums = [1, 1, 0, 1, 1, 1]
```

**Output:**
```text
3
```

**Explanation:** The longest consecutive group is `[1, 1, 1]`, which contains three ones.

## Approach: Counting

1. Initialize `count = 0` to count consecutive ones.
2. Initialize `maxCount = 0` to store the maximum consecutive ones found.
3. Traverse the array using a `for` loop.
4. If the current element is `1`, increment `count`.
5. If the current element is `0`, update `maxCount` if `count` is greater, then reset `count` to `0`.
6. After the loop, compare `count` with `maxCount` once more because the array may end with ones.
7. Return `maxCount`.

## Java Solution

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 0;
            }
        }

        if (count > maxCount) {
            maxCount = count;
        }

        return maxCount;
    }
}
```

## Dry Run

Input: `[1, 1, 0, 1, 1, 1]`

| Element | `count` | `maxCount` |
|---:|---:|---:|
| 1 | 1 | 0 |
| 1 | 2 | 0 |
| 0 | 0 | 2 |
| 1 | 1 | 2 |
| 1 | 2 | 2 |
| 1 | 3 | 2 |
| End of loop | 3 | 3 |

**Output:** `3`

## Complexity Analysis

- **Time Complexity:** `O(n)` — each array element is visited once.
- **Auxiliary Space:** `O(1)` — only two counter variables are used.

## Concepts Learned

- Array traversal
- `for` loops and `if-else` conditions
- Counter variables
- Finding a maximum without `Math.max()`
- Handling the final group after a loop

## Common Mistake

Do not forget the final comparison after the loop. If the array ends with consecutive ones, no zero occurs to update `maxCount` inside the loop.

## Practice Status

- [x] Solution implemented
- [x] Dry run completed
- [x] Time and space complexity understood
