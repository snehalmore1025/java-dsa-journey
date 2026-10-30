# LeetCode 28 – Find the Index of the First Occurrence in a String

## Problem Statement

Given two strings `haystack` and `needle`, return the index of the first occurrence of `needle` in `haystack`.

If `needle` is not part of `haystack`, return `-1`.

### Example 1

**Input:**
```java
haystack = "sadbutsad";
needle = "sad";
```

**Output:**
```text
0
```

**Explanation:** The substring `"sad"` first occurs at index `0`.

### Example 2

**Input:**
```java
haystack = "leetcode";
needle = "leeto";
```

**Output:**
```text
-1
```

**Explanation:** `"leeto"` does not occur in `"leetcode"`.

### Example 3

**Input:**
```java
haystack = "hello";
needle = "ll";
```

**Output:**
```text
2
```

**Explanation:** `"ll"` first occurs at index `2`.

---

## Approach – Brute Force String Matching

1. Calculate the lengths of both strings.
2. Use an outer `for` loop to check every possible starting position in `haystack`.
3. Initialize `j = 0` for each starting position.
4. Use a `while` loop to compare characters from both strings.
5. If characters match, increment `j`.
6. If `j` becomes equal to the length of `needle`, all characters have matched. Return `i`.
7. If no match is found, return `-1`.

### Why do we use `n - m`?

Let:
- `n` = length of `haystack`.
- `m` = length of `needle`.

The last possible starting position is:

```java
n - m
```

We use:

```java
i <= n - m
```

This ensures that the complete `needle` can fit inside `haystack` without accessing an invalid index.

For example:

```java
haystack = "hello"; // n = 5
needle = "ll";      // m = 2
```

```text
n - m = 5 - 2 = 3
```

The last possible starting index is `3`.

---

## Java Solution

```java
class Solution {
    public int strStr(String haystack, String needle) {

        // Step 1: Get lengths of both strings
        int n = haystack.length();
        int m = needle.length();

        // Step 2: Check every possible starting position
        for (int i = 0; i <= n - m; i++) {

            // Step 3: Start comparing characters
            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // Step 4: If all needle characters matched
            if (j == m) {
                return i;
            }
        }

        // Step 5: Needle was not found
        return -1;
    }
}
```

---

## Dry Run

**Input:**

```java
haystack = "hello";
needle = "ll";
```

### Code Line Reference

- L1: `int n = haystack.length();`
- L2: `int m = needle.length();`
- L3: `for (int i = 0; i <= n - m; i++)`
- L4: `int j = 0;`
- L5: `while (j < m && haystack.charAt(i + j) == needle.charAt(j))`
- L6: `j++;`
- L7: `if (j == m)`
- L8: `return i;`
- L9: `return -1;`

### Complete Dry Run Table

| Step | L3: `i <= n - m` | L4: `j = 0` | L5: `while` condition | L6: `j++` | L7: `j == m` | Result |
|---|---|---|---|---|---|---|
| Initialization | — | — | — | — | — | `n = 5`, `m = 2` |
| Iteration 1 | `0 <= 3` = `true` | `j = 0` | `'h' == 'l'` = `false` | Not executed | `0 == 2` = `false` | No match |
| Iteration 2 | `1 <= 3` = `true` | `j = 0` | `'e' == 'l'` = `false` | Not executed | `0 == 2` = `false` | No match |
| Iteration 3 | `2 <= 3` = `true` | `j = 0` | `'l' == 'l'` = `true` | `j = 1` | Not checked yet | First character matches |
| Check again | — | — | `'l' == 'l'` = `true` | `j = 2` | Not checked yet | Second character matches |
| Check again | — | — | `j < m` → `2 < 2` = `false` | Not executed | `2 == 2` = `true` | Complete match |
| Return | — | — | — | — | — | Returns `2` |

**Final Output:**

```text
2
```

---

## Understanding the Important Variables

| Variable | Purpose |
|---|---|
| `n` | Length of `haystack` |
| `m` | Length of `needle` |
| `i` | Starting position currently being checked in `haystack` |
| `j` | Current character position inside `needle` |

### Understanding `i + j`

When `i = 2` and `j = 1`:

```java
haystack.charAt(i + j)
```

becomes:

```java
haystack.charAt(3)
```

And:

```java
needle.charAt(j)
```

becomes:

```java
needle.charAt(1)
```

Both characters are `'l'`, so they match.

---

## Important Java Concepts

| Method / Operator | Purpose |
|---|---|
| `length()` | Returns the number of characters in a string |
| `charAt(index)` | Returns the character at a given index |
| `&&` | Logical AND; both conditions must be true |
| `i++` | Increments the starting position |
| `j++` | Moves to the next character in the needle |
| `return i` | Returns the first matching starting index |
| `return -1` | Indicates that no match was found |

---

## Time and Space Complexity

Let:
- `n` = length of `haystack`.
- `m` = length of `needle`.

**Time Complexity: O((n - m + 1) × m)**

In the worst case, for each possible starting position, we may compare up to `m` characters.

This is also commonly expressed as **O(n × m)**.

**Auxiliary Space Complexity: O(1)**

We use only a fixed number of variables (`n`, `m`, `i`, and `j`). No additional data structure is required.

---

## Key Learning

1. `haystack` is the main string.
2. `needle` is the string we want to find.
3. `i` represents the starting index in `haystack`.
4. `j` represents the character index in `needle`.
5. `i + j` identifies the corresponding character in `haystack`.
6. `n - m` calculates the last possible starting position.
7. `j == m` confirms that the entire needle has matched.

---

## LeetCode Details

- **Problem Number:** 28
- **Problem Name:** Find the Index of the First Occurrence in a String
- **Difficulty:** Easy
- **Topic:** Strings
- **Approach:** Brute Force String Matching
- **Language:** Java