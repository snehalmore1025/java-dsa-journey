# LeetCode 58 – Length of Last Word

## Problem Statement

Given a string `s` consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

### Example 1

**Input:**
```java
s = "Hello World"
```

**Output:**
```text
5
```

**Explanation:** The last word is `"World"`, which has 5 characters.

### Example 2

**Input:**
```java
s = "   fly me   to   the moon  "
```

**Output:**
```text
4
```

**Explanation:** The last word is `"moon"`, which has 4 characters.

### Example 3

**Input:**
```java
s = "luffy is still joyboy"
```

**Output:**
```text
6
```

**Explanation:** The last word is `"joyboy"`, which has 6 characters.

---

## Approach – Traverse from Right to Left

Instead of starting from the beginning, we traverse the string from right to left.

1. Initialize `i` to the last index of the string.
2. Use the first `while` loop to skip spaces at the end.
3. Initialize `count = 0`.
4. Use the second `while` loop to count characters until a space is encountered or the beginning of the string is reached.
5. Return `count`.

---

## Java Solution

```java
class Solution {
    public int lengthOfLastWord(String s) {

        // Step 1: Start from the last index
        int i = s.length() - 1;

        // Step 2: Skip spaces at the end
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 3: Initialize word length
        int count = 0;

        // Step 4: Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        // Step 5: Return the length
        return count;
    }
}
```

---

## Dry Run

**Input:**

```java
String s = "Hello World   ";
```

### Code Line Reference

- L1: `int i = s.length() - 1;`
- L2: `while (i >= 0 && s.charAt(i) == ' ')`
- L3: `i--;`
- L4: `int count = 0;`
- L5: `while (i >= 0 && s.charAt(i) != ' ')`
- L6: `count++;`
- L7: `i--;`
- L8: `return count;`

### Complete Dry Run Table

| Step | L1: `i = s.length() - 1` | L2: First `while` condition | L3: `i--` | L4: `count = 0` | L5: Second `while` condition | L6: `count++` | L7: `i--` |
|---|---|---|---|---|---|---|---|
| Initialization | String length = 14, so `i = 13` | First loop is ready to check the last character | Waiting for condition | Count has not been initialized yet | Second loop has not started | Waiting for loop | Waiting for loop |
| Skip space 1 | `i = 13` | `s.charAt(13) == ' '` → true. Current character is a space | Move left: `i = 12` | Count has not been initialized yet | Second loop has not started | Waiting for loop | Waiting for loop |
| Skip space 2 | `i = 12` | `s.charAt(12) == ' '` → true. Current character is a space | Move left: `i = 11` | Count has not been initialized yet | Second loop has not started | Waiting for loop | Waiting for loop |
| Skip space 3 | `i = 11` | `s.charAt(11) == ' '` → true. Current character is a space | Move left: `i = 10` | Count has not been initialized yet | Second loop has not started | Waiting for loop | Waiting for loop |
| Stop first loop | `i = 10` | `s.charAt(10) == ' '` → false. Current character is `'d'` | First loop stops; `i` remains 10 | Count has not been initialized yet | Second loop is ready to start | Waiting for loop | Waiting for loop |
| Initialize count | `i = 10` | First loop has finished skipping spaces | `i` stays 10 | Initialize `count = 0` | Second loop is ready to check the last word | Waiting for loop | Waiting for loop |
| Count 1 | `i = 10` | First loop has finished | `i` is 10 | `count = 0` | `10 >= 0 && 'd' != ' '` → true | Count `'d'`: `count = 1` | Move left: `i = 9` |
| Count 2 | `i = 9` | First loop has finished | `i` is 9 | `count = 1` | `9 >= 0 && 'l' != ' '` → true | Count `'l'`: `count = 2` | Move left: `i = 8` |
| Count 3 | `i = 8` | First loop has finished | `i` is 8 | `count = 2` | `8 >= 0 && 'r' != ' '` → true | Count `'r'`: `count = 3` | Move left: `i = 7` |
| Count 4 | `i = 7` | First loop has finished | `i` is 7 | `count = 3` | `7 >= 0 && 'o' != ' '` → true | Count `'o'`: `count = 4` | Move left: `i = 6` |
| Count 5 | `i = 6` | First loop has finished | `i` is 6 | `count = 4` | `6 >= 0 && 'W' != ' '` → true | Count `'W'`: `count = 5` | Move left: `i = 5` |
| Stop second loop | `i = 5` | First loop has finished | `i` is 5 | `count = 5` | `5 >= 0 && ' ' != ' '` → false. We reached the space before `"World"` | No more characters are counted | Second loop stops; `i` remains 5 |
| Return | `i = 5` | Both loops have completed | No further movement | Final count is 5 | Second loop has stopped | Five characters counted | No further movement |

**Final Output:**

```text
5
```

---

## Understanding the Two While Loops

### First while loop – Skip trailing spaces

```java
while (i >= 0 && s.charAt(i) == ' ') {
    i--;
}
```

- Checks whether the current character is a space.
- If it is a space, moves one position to the left.
- Stops when it reaches a non-space character.

### Second while loop – Count the last word

```java
while (i >= 0 && s.charAt(i) != ' ') {
    count++;
    i--;
}
```

- Checks whether the current character is not a space.
- Increments `count` for every character.
- Moves one position to the left.
- Stops when it reaches a space or the beginning of the string.

---

## Important Java Concepts

| Concept | Purpose |
|---|---|
| `length()` | Returns the number of characters in a string |
| `charAt(i)` | Returns the character at a particular index |
| `s.charAt(i) == ' '` | Checks whether the character is a space |
| `s.charAt(i) != ' '` | Checks whether the character is not a space |
| `i--` | Moves one position to the left |
| `count++` | Increases the word length by one |
| `&&` | Logical AND; both conditions must be true |

---

## Time and Space Complexity

**Time Complexity: O(n)**

In the worst case, we traverse the entire string from right to left.

**Auxiliary Space Complexity: O(1)**

We use only two integer variables, `i` and `count`. No additional data structures are required.

---

## Key Learning

1. Java string indexing starts from zero.
2. `s.length() - 1` gives the last valid index.
3. We can traverse a string backwards using `i--`.
4. The first loop skips trailing spaces.
5. The second loop counts characters of the last word.
6. We stop counting when we encounter a space.
7. The `count` variable stores the length of the last word.

---

## LeetCode Details

- **Problem Number:** 58
- **Problem Name:** Length of Last Word
- **Difficulty:** Easy
- **Topic:** Strings
- **Approach:** Right-to-Left Traversal
- **Language:** Java