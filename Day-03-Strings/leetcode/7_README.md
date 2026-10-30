# LeetCode 387 – First Unique Character in a String

**Problem:** Find the first non-repeating character in a string and return its index. If no unique character exists, return `-1`.

## Examples

| Input | Output |
|---|---:|
| `"leetcode"` | 0 |
| `"loveleetcode"` | 2 |
| `"aabb"` | -1 |

## Approach: Frequency Array

1. Create an integer array of size 26 to store character frequencies.
2. Traverse the string and count each character.
3. Traverse the string again from left to right.
4. Return the index of the first character whose frequency is exactly 1.
5. If no unique character exists, return `-1`.

## Java Code

```java
class Solution {
    public int firstUniqChar(String s) {

        int[] freq = new int[26];

        // Count character frequencies
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            freq[index]++;
        }

        // Find the first unique character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';

            if (freq[index] == 1) {
                return i;
            }
        }

        return -1;
    }
}
```

## Dry Run

**Input:** `s = "loveleetcode"`

### Table 1: First loop – Count frequencies

| `i` | `char ch = s.charAt(i)` | `int index = ch - 'a'` | `freq[index]++` |
|---:|---|---:|---|
| 0 | Reads `l` | 11 | `freq[11]` becomes 1 |
| 1 | Reads `o` | 14 | `freq[14]` becomes 1 |
| 2 | Reads `v` | 21 | `freq[21]` becomes 1 |
| 3 | Reads `e` | 4 | `freq[4]` becomes 1 |
| 4 | Reads `l` | 11 | `freq[11]` becomes 2 |
| 5 | Reads `e` | 4 | `freq[4]` becomes 2 |
| 6 | Reads `e` | 4 | `freq[4]` becomes 3 |
| 7 | Reads `t` | 19 | `freq[19]` becomes 1 |
| 8 | Reads `c` | 2 | `freq[2]` becomes 1 |
| 9 | Reads `o` | 14 | `freq[14]` becomes 2 |
| 10 | Reads `d` | 3 | `freq[3]` becomes 1 |
| 11 | Reads `e` | 4 | `freq[4]` becomes 4 |

**Frequency summary:**

| Character | Frequency |
|---|---:|
| l | 2 |
| o | 2 |
| v | 1 |
| e | 4 |
| t | 1 |
| c | 1 |
| d | 1 |

### Table 2: Second loop – Find first unique character

| `i` | `char ch = s.charAt(i)` | `int index = ch - 'a'` | `if (freq[index] == 1)` | `return i` |
|---:|---|---:|---|---|
| 0 | Reads `l` | 11 | `freq[11] = 2`; false | Continues to next character |
| 1 | Reads `o` | 14 | `freq[14] = 2`; false | Continues to next character |
| 2 | Reads `v` | 21 | `freq[21] = 1`; true | Returns 2; method ends |

**Output:** `2`

## Java Concepts Used

- Strings and `charAt()`
- Integer arrays
- Character-to-index conversion using `ch - 'a'`
- For loops
- Conditional statements
- Frequency counting

## Complexity Analysis

| Complexity | Value | Explanation |
|---|---|---|
| Time | O(n) | Two traversals of the string |
| Space | O(1) | Frequency array always has 26 positions |

## Key Learning

A frequency array helps count character occurrences efficiently. The first loop counts all characters, while the second loop finds the first character with frequency 1.

**LeetCode:** 387 – First Unique Character in a String  
**Difficulty:** Easy  
**Topic:** Strings, Arrays, Frequency Counting