# LeetCode 1295 — Find Numbers with Even Number of Digits

## Problem
Given an array of integers `nums`, return how many numbers contain an even number of digits.

## Example
**Input:** `nums = [12, 345, 2, 7896]`

**Output:** `2`

**Explanation:** `12` has two digits and `7896` has four digits. Both have an even number of digits.

## Approach
1. Initialize `res = 0` to count numbers with an even number of digits.
2. Traverse each number in the array.
3. Set `cnt = 0` and copy the current number into `num`.
4. While `num > 0`, increment `cnt` and divide `num` by `10`.
5. If `cnt % 2 == 0`, increment `res`.
6. Return `res`.

## Java Solution
```java
class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            int num = nums[i];

            while (num > 0) {
                cnt++;
                num = num / 10;
            }

            if (cnt % 2 == 0) {
                res++;
            }
        }

        return res;
    }
}
```

## Dry Run

Input: `[12, 345, 2, 7896]`

| Number | Digit count | Even number of digits? | `res` |
|---:|---:|---|---:|
| 12 | 2 | Yes | 1 |
| 345 | 3 | No | 1 |
| 2 | 1 | No | 1 |
| 7896 | 4 | Yes | 2 |

**Output:** `2`

## Complexity
- **Time:** `O(n × d)`, where `n` is the number of array elements and `d` is the maximum number of digits in a number.
- **Auxiliary space:** `O(1)` — only a few variables are used.

## Concepts Learned
- Array traversal
- Nested loops (a loop inside another loop)
- Modulo operator `%`
- Integer division `/`
- Counting digits
- Checking even numbers with `% 2`

## Important Note
Use a temporary variable `num` for digit counting so the original array values remain unchanged.

## Practice Status
- [x] Solution implemented
- [x] TLE cause understood and fixed
- [x] Dry run completed
- [x] Complexity understood
