# LeetCode 14 – Longest Common Prefix

## Problem Statement

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

A prefix is a sequence of characters that appears at the beginning of a string.

### Example 1

**Input:**
```java
strs = ["flower", "flow", "flight"]
```

**Output:**
```text
"fl"
```

**Explanation:**  
The longest common prefix shared by all three strings is `"fl"`.

### Example 2

**Input:**
```java
strs = ["dog", "racecar", "car"]
```

**Output:**
```text
""
```

**Explanation:**  
There is no common prefix among the strings.

### Example 3 – First String Is the Shortest

**Input:**
```java
strs = ["flow", "flower", "flight"]
```

**Output:**
```text
"fl"
```

**Explanation:**  
We initially take `"flow"` as the prefix because it is the first string. We then compare it with the remaining strings and shorten it when necessary.

---

## Approach – Horizontal Scanning

1. First, check whether the array is null or empty. If it is, return `""`.
2. Take the first string as the initial prefix.
3. Traverse the remaining strings using a `for` loop.
4. Check whether each string starts with the current prefix using `startsWith()`.
5. If it does not match, shorten the prefix by removing its last character using `substring()`.
6. Repeat until the current string starts with the prefix.
7. If the prefix becomes empty, return `""`.
8. After checking all strings, return the remaining prefix.

## Java Solution

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Step 1: Handle an empty or null array
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Step 2: Assume the first string is the prefix
        String prefix = strs[0];

        // Step 3: Check every remaining string
        for (int i = 1; i < strs.length; i++) {

            // Step 4: Shorten the prefix while it does not match
            while (!strs[i].startsWith(prefix)) {

                // Remove the last character of the prefix
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Step 5: Return the longest prefix shared by all strings
        return prefix;
    }
}
```

---

## Dry Run

**Input:**
```java
String[] strs = {"flow", "flower", "flight"};
```

### Code Line Reference

- L1: `String prefix = strs[0];`
- L2: `for (int i = 1; i < strs.length; i++)`
- L3: `while (!strs[i].startsWith(prefix))`
- L4: `prefix = prefix.substring(0, prefix.length() - 1);`
- L5: `if (prefix.isEmpty())`
- L6: `return "";`
- L7: `return prefix;`

### Complete Dry Run

| Step | L2: `i` | L3: `startsWith()` condition | L4: `substring()` operation | L5: `isEmpty()` | Result |
|---|---|---|---|---|---|
| Initialization (L1) | — | — | — | — | `prefix = "flow"` |
| Iteration 1 | `i = 1` | `!("flower".startsWith("flow"))` = `false` | Not executed | Not executed | Prefix remains `"flow"` |
| Iteration 2 | `i = 2` | `!("flight".startsWith("flow"))` = `true` | `"flow"` → `"flo"` | `false` | Continue while loop |
| Check again | `i = 2` | `!("flight".startsWith("flo"))` = `true` | `"flo"` → `"fl"` | `false` | Continue while loop |
| Check again | `i = 2` | `!("flight".startsWith("fl"))` = `false` | Not executed | Not executed | Prefix remains `"fl"` |
| Loop ends | `i = 3` | `3 < 3` = `false` | Not executed | Not executed | Outer loop terminates |
| Return (L7) | — | — | — | — | Returns `"fl"` |

**Final Output:**
```text
"fl"
```

---

## Time and Space Complexity

Let:
- `n` = number of strings in the array.
- `m` = length of the first string.

**Time Complexity: O(n × m)**

In the worst case, we compare and shorten the prefix across the strings. The prefix can have at most `m` characters, and we process up to `n` strings.

**Auxiliary Space Complexity: O(m)**

String operations can create intermediate strings while shortening the prefix. The maximum prefix length is `m`.

---

## Important Java Methods

| Method | Purpose |
|---|---|
| `startsWith()` | Checks whether a string begins with a given prefix |
| `substring()` | Extracts a portion of a string |
| `length()` | Returns the length of a string |
| `isEmpty()` | Checks whether a string is empty |

## Key Learning

- A prefix must appear at the beginning of every string.
- We can initially take the first string as the prefix.
- We do not need to find the longest string first.
- `startsWith()` helps compare prefixes.
- `substring()` helps shorten the prefix when a mismatch occurs.
- The same prefix variable is updated until it matches all strings.

## LeetCode Details

- **Problem Number:** 14
- **Problem Name:** Longest Common Prefix
- **Difficulty:** Easy
- **Topic:** Strings
- **Approach:** Horizontal Scanning
- **Language:** Java