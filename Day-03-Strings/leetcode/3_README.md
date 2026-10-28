# LeetCode 125 — Valid Palindrome

## Problem Statement

Given a string `s`, determine whether it is a palindrome, considering only alphanumeric characters and ignoring cases.

Return `true` if it is a palindrome; otherwise, return `false`.

A **palindrome** is a string that reads the same forward and backward after ignoring non-alphanumeric characters and letter case.

**Problem Link:** https://leetcode.com/problems/valid-palindrome/

## Examples

### Example 1

**Input:**
```text
s = "A man, a plan, a canal: Panama"
```

**Output:**
```text
true
```

**Explanation:** After removing spaces and punctuation and converting to lowercase, the string becomes `"amanaplanacanalpanama"`, which reads the same forward and backward.

### Example 2

**Input:**
```text
s = "race a car"
```

**Output:**
```text
false
```

**Explanation:** After ignoring spaces and case, the characters do not read the same backward.

### Example 3

**Input:**
```text
s = " "
```

**Output:**
```text
true
```

**Explanation:** There are no alphanumeric characters to compare, so the string is considered a palindrome.

## Approach: Two Pointers

Use two pointers to compare characters from opposite ends of the string.

1. Initialize `left = 0` and `right = s.length() - 1`.
2. Skip non-alphanumeric characters from the left using `Character.isLetterOrDigit()`.
3. Skip non-alphanumeric characters from the right using the same method.
4. Convert both characters to lowercase and compare them.
5. If the characters differ, return `false`.
6. If they match, move `left` forward and `right` backward.
7. If all comparisons match, return `true`.

## Java Solution

```java
class Solution {
    public boolean isPalindrome(String s) {

        // Pointer to the first character
        int left = 0;

        // Pointer to the last character
        int right = s.length() - 1;

        // Continue while the pointers have not crossed
        while (left < right) {

            // Skip non-alphanumeric characters from the left
            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from the right
            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters without considering case
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Move both pointers inward
            left++;
            right--;
        }

        // All character comparisons matched
        return true;
    }
}
```

## Dry Run

**Input:**
```text
s = "A man, a plan, a canal: Panama"
```

After ignoring spaces and punctuation and treating uppercase and lowercase letters equally, the comparisons are:

| Step | Left character | Right character | Match? |
|---:|:---:|:---:|:---:|
| 1 | a | a | Yes |
| 2 | m | m | Yes |
| 3 | a | a | Yes |
| 4 | n | n | Yes |
| 5 | a | a | Yes |
| 6 | p | p | Yes |
| 7 | l | l | Yes |
| 8 | a | a | Yes |
| 9 | n | n | Yes |
| 10 | a | a | Yes |

The pointers continue moving inward, skipping spaces and punctuation. All character comparisons match.

**Output:**
```text
true
```

## Understanding Important Methods

### 1. `s.charAt(left)`

Returns the character at the position indicated by `left`.

### 2. `Character.isLetterOrDigit()`

Checks whether a character is a letter or a digit. It returns `false` for spaces and punctuation.

### 3. `Character.toLowerCase()`

Converts a character to lowercase for case-insensitive comparison.

For example, `'A'` and `'a'` are treated as equal.

### 4. `left++` and `right--`

Move the left pointer one position forward and the right pointer one position backward.

### 5. `while (left < right)`

Ensures that comparisons continue only while the pointers have not met or crossed.

## Complexity Analysis

- **Time Complexity:** `O(n)` — the pointers traverse the string at most once.
- **Auxiliary Space Complexity:** `O(1)` — only a fixed number of variables are used; no additional string or array is created.

Here, `n` is the length of the input string.

## Key Learning

This problem demonstrates the **two-pointer technique**, which is useful for palindrome checks and other problems involving comparisons from opposite ends of a sequence.

It also introduces useful Java methods for character validation and case conversion.

## Git Commands

Run these commands from the root of your `java-dsa-journey` repository:

```powershell
git add Day-03-Strings/leetcode/3_ValidPalindrome.java Day-03-Strings/leetcode/3_README.md
git commit -m "Solve LeetCode 125 Valid Palindrome"
git push origin main
```
