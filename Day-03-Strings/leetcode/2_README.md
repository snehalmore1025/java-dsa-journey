# LeetCode 242 — Valid Anagram

## Problem Statement

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

An **anagram** is a word formed by rearranging the letters of another word, using each letter the same number of times.

**Problem Link:** https://leetcode.com/problems/valid-anagram/

## Examples

**Example 1**

Input:
```text
s = "anagram"
t = "nagaram"
```

Output:
```text
true
```

Explanation: Both strings contain the same characters with the same frequencies.

**Example 2**

Input:
```text
s = "rat"
t = "car"
```

Output:
```text
false
```

Explanation: The strings contain different character frequencies.

## Approach: Frequency Array

Use an integer array of size 26 to store the frequency of each lowercase English letter.

- Each array index represents a letter: index `0` represents `a`, index `1` represents `b`, and so on.
- First, count the occurrences of every character in `s`.
- Next, decrease the corresponding frequency for every character in `t`.
- Finally, check whether all array values are zero. If they are, the strings are anagrams.

### Java Solution

```java
class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Create 26 counters for letters a to z
        int[] freq = new int[26];

        // Count the characters in string s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Convert the character into an array index
            int index = ch - 'a';

            // Increase its frequency
            freq[index]++;
        }

        // Subtract the characters found in string t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            // Convert the character into an array index
            int index = ch - 'a';

            // Decrease its frequency
            freq[index]--;
        }

        // Check whether every frequency is zero
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        // All character frequencies match
        return true;
    }
}
```

## Dry Run

Input:

```text
s = "anagram"
t = "nagaram"
```

### Step 1: Count characters in `s`

After the first loop, the frequency array contains:

| Character | Frequency |
|---|---:|
| a | 3 |
| g | 1 |
| m | 1 |
| n | 1 |
| r | 1 |

All other characters have frequency `0`.

### Step 2: Subtract characters in `t`

The second loop uses the same `freq` array. Each character in `t` decreases its corresponding counter.

| Iteration (`i`) | `t.charAt(i)` | Frequency before | Frequency after |
|---:|:---:|---:|---:|
| 0 | n | 1 | 0 |
| 1 | a | 3 | 2 |
| 2 | g | 1 | 0 |
| 3 | a | 2 | 1 |
| 4 | r | 1 | 0 |
| 5 | a | 1 | 0 |
| 6 | m | 1 | 0 |

After the second loop, every character counter is `0`.

### Step 3: Final check

The third loop checks all 26 array positions.

Since no frequency differs from zero, the method returns:

```text
true
```

## Understanding the Important Lines

**1. `int[] freq = new int[26];`**

Creates an array with 26 integer counters. Java initializes every counter to `0`.

**2. `int index = ch - 'a';`**

Converts a lowercase letter into an array index.

For example, if `ch = 'a'`, the index is `0`. If `ch = 'c'`, the index is `2`.

**3. `freq[index]++;`**

Increases the counter for the current character by one.

**4. `freq[index]--;`**

Decreases the counter for the current character by one. It updates the same array that the first loop populated.

**5. `if (freq[i] != 0)`**

If any counter is nonzero, the strings have different character frequencies, so the method returns `false`.

## Complexity Analysis

- **Time Complexity:** `O(n)` — the method makes at most three passes, and the array has a fixed size of 26.
- **Space Complexity:** `O(1)` — the frequency array always contains 26 integers, regardless of the input length.

Here, `n` is the length of the strings.

## Key Learning

This problem demonstrates how a **frequency array** can compare character counts efficiently without sorting either string.

**Important assumption:** This solution works for lowercase English letters `a` to `z`. Inputs containing uppercase letters, spaces, punctuation, or other characters require additional handling.

## Git Commands

Run these commands from the root of your `java-dsa-journey` repository:

```powershell
git add Day-03-Strings/leetcode/2_ValidAnagram.java Day-03-Strings/leetcode/2_README.md
git commit -m "Solve LeetCode 242 Valid Anagram"
git push origin main
```
