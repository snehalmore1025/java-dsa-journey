# LeetCode 344: Reverse String

## Problem Statement

Given a character array `s`, reverse the array in place.

You must modify the original array without creating another array to store the reversed result.

- **LeetCode:** [344. Reverse String](https://leetcode.com/problems/reverse-string/)
- **Difficulty:** Easy
- **Topics:** Two Pointers, Array, String

## Example 1

**Input**
```text
s = ["h","e","l","l","o"]
```

**Output**
```text
["o","l","l","e","h"]
```

## Example 2

**Input**
```text
s = ["H","a","n","n","a","h"]
```

**Output**
```text
["h","a","n","n","a","H"]
```

## Approach: Two Pointers

1. Initialize `left = 0` to point to the first character.
2. Initialize `right = s.length - 1` to point to the last character.
3. While `left < right`, swap the characters at these positions using a temporary variable.
4. Increment `left` and decrement `right`.
5. Stop when the pointers meet or cross.

## Java Solution

```java
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
```

## Dry Run

**Input:** `['h', 'e', 'l', 'l', 'o']`

Initial state:

| Index | 0 | 1 | 2 | 3 | 4 |
|---|---|---|---|---|---|
| Character | h | e | l | l | o |

Initially, `left = 0` and `right = 4`.

| Iteration | `left` | `right` | `s[left]` | `s[right]` | Operation | Array after operation |
|---:|---:|---:|:---:|:---:|---|---|
| 1 | 0 | 4 | h | o | Swap h and o | `['o','e','l','l','h']` |
| 2 | 1 | 3 | e | l | Swap e and l | `['o','l','l','e','h']` |
| 3 | 2 | 2 | l | l | Condition `left < right` is false | No swap |

### Final Output

```text
["o","l","l","e","h"]
```

### How the swap works

```java
char temp = s[left];
s[left] = s[right];
s[right] = temp;
```

For the first iteration:

1. `temp = s[0]` stores `'h'`.
2. `s[0] = s[4]` places `'o'` at index 0.
3. `s[4] = temp` places `'h'` at index 4.

The array becomes `['o', 'e', 'l', 'l', 'h']`.

After each swap, `left` moves one position forward and `right` moves one position backward.

## Complexity Analysis

- **Time Complexity:** O(n), where n is the length of the character array.
- **Auxiliary Space Complexity:** O(1), because only two pointers and a temporary variable are used.

## Key Learnings

- Applying the two-pointer technique.
- Swapping array elements without creating another array.
- Modifying an array in place.
- Using a loop condition to stop when pointers meet or cross.
