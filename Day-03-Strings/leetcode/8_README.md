# LeetCode 383 – Ransom Note

**Problem:** Given two strings, `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed using the characters from `magazine`. Each character in `magazine` can only be used once. Otherwise, return `false`.

## Examples

| ransomNote | magazine | Output |
|---|---|---|
| `"a"` | `"b"` | `false` |
| `"aa"` | `"ab"` | `false` |
| `"aa"` | `"aab"` | `true` |

## Approach: Frequency Array

1. Create an integer array of size 26.
2. Traverse `magazine` and count the frequency of each character.
3. Traverse `ransomNote` and check whether each required character is available.
4. If a character's frequency is zero, return `false`.
5. Otherwise, decrease its frequency because that character has been used.
6. If all characters are available, return `true`.

## Java Code

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] freq = new int[26];

        // Count characters in magazine
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            int index = ch - 'a';
            freq[index]++;
        }

        // Use characters required by ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            int index = ch - 'a';

            if (freq[index] == 0) {
                return false;
            }

            freq[index]--;
        }

        return true;
    }
}
```

## Dry Run

**Input:**

```java
String ransomNote = "aa";
String magazine = "aab";
```

### Table 1: First loop – Count magazine frequencies

| `i` | `char ch = magazine.charAt(i)` | `int index = ch - 'a'` | `freq[index]++` |
|---:|---|---:|---|
| 0 | Reads `a` | 0 | `freq[0]` becomes 1 |
| 1 | Reads `a` | 0 | `freq[0]` becomes 2 |
| 2 | Reads `b` | 1 | `freq[1]` becomes 1 |

**Frequency after the first loop:**

| Character | Available frequency |
|---|---:|
| a | 2 |
| b | 1 |

### Table 2: Second loop – Use ransom note characters

| `i` | `char ch = ransomNote.charAt(i)` | `int index = ch - 'a'` | `if (freq[index] == 0)` | `freq[index]--` |
|---:|---|---:|---|---|
| 0 | Reads first `a` | 0 | `freq[0] = 2`; condition is false | `freq[0]` decreases from 2 to 1 |
| 1 | Reads second `a` | 0 | `freq[0] = 1`; condition is false | `freq[0]` decreases from 1 to 0 |

After both characters are used, the loop finishes and `return true` executes.

**Output:** `true`

## Java Concepts Used

- Strings
- Character access using `charAt()`
- Integer arrays
- Character-to-index conversion using `ch - 'a'`
- Frequency counting
- For loops
- If conditions

## Complexity Analysis

| Complexity | Value | Explanation |
|---|---|---|
| Time | O(n + m) | One traversal of magazine and one traversal of ransomNote |
| Space | O(1) | Frequency array always contains 26 positions |

Here, `n` is the length of `magazine` and `m` is the length of `ransomNote`.

## Key Learning

- The frequency array tracks available characters.
- `freq[index]++` counts available characters.
- `freq[index]--` uses one available character.
- Checking `freq[index] == 0` prevents using a character more times than it appears.
- Each character in the magazine can be used only once.

**LeetCode:** 383 – Ransom Note  
**Difficulty:** Easy  
**Topic:** Strings, Arrays, Frequency Counting