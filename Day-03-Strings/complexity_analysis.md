# Day 3 — String Complexity Analysis

Let `n` be the number of characters in the input string. Complexity statements below describe typical Java implementations and the algorithmic work performed; exact library implementation details can vary.

## 1. String Operations

| Operation | Time Complexity | Extra Space | Notes |
|---|---:|---:|---|
| `length()` | `O(1)` | `O(1)` | String length is available directly. |
| `charAt(i)` | `O(1)` | `O(1)` | Assumes `i` is a valid index. |
| `equals()` | `O(n)` worst case | `O(1)` | May stop early on a mismatch; may compare up to the full length. |
| `equalsIgnoreCase()` | `O(n)` worst case | `O(1)` | May examine the characters in both strings. |
| `compareTo()` | `O(n)` worst case | `O(1)` | Stops at the first difference or the end of a common prefix. |
| `contains(sequence)` | Up to `O(nm)` for a simple search model | Usually `O(1)` auxiliary | `n` is text length and `m` is searched-sequence length; actual Java implementation may use optimized searching. |
| `indexOf()` / `lastIndexOf()` | Up to `O(nm)` in a simple search model | Usually `O(1)` auxiliary | Actual implementation details can affect performance. |
| `substring(begin, end)` | Typically `O(k)` | Typically `O(k)` | `k` is the returned substring length in modern Java implementations. |
| `toCharArray()` | `O(n)` | `O(n)` | Copies the characters into an array. |
| `toUpperCase()` / `toLowerCase()` | `O(n)` relative to text size | Up to `O(n)` | Locale and Unicode case mappings can affect details and output length. |
| `trim()` | `O(n)` worst case | Up to `O(n)` | May scan the edges and produce a result. |
| `split(regex)` | Depends on regex and input; commonly at least `O(n)` | `O(n)` for resulting pieces | Complex regular expressions can take much longer. |
| `StringBuilder.append(x)` | Amortized `O(k)` for appending `k` characters | May grow with capacity | Occasional capacity expansion copies existing content. |
| `StringBuilder.reverse()` | `O(n)` | Typically `O(1)` auxiliary beyond builder storage | Reverses the builder's current sequence. |

For substring operations, `k` is the output length. Avoid assuming that creating a substring is always constant time.

## 2. Algorithm Analysis

### A. Reverse a String with a Character Array

Algorithm:
1. Convert the string to a character array.
2. Set `left = 0` and `right = n - 1`.
3. Swap the characters at those indexes.
4. Move both pointers inward until they meet or cross.
5. Create the resulting string.

| Resource | Complexity | Reason |
|---|---:|---|
| Time | `O(n)` | Conversion, swaps, and result creation each take linear time. |
| Auxiliary space | `O(n)` | The character array stores `n` characters; result creation may require additional output storage. |

The swap loop alone performs about `n / 2` swaps, which is `O(n)`.

### B. Reverse a String with `StringBuilder`

```java
String reversed = new StringBuilder(text).reverse().toString();
```

| Resource | Complexity | Reason |
|---|---:|---|
| Time | `O(n)` | Builder creation, reversal, and conversion process `n` characters. |
| Auxiliary space | `O(n)` | Builder and resulting string require storage proportional to the input/output size. |

### C. Check a Palindrome with Two Pointers

Algorithm:
1. Start one pointer at the beginning and one at the end.
2. Compare the two characters.
3. If they differ, return `false`.
4. Otherwise move both pointers inward.
5. If every compared pair matches, return `true`.

| Resource | Complexity | Reason |
|---|---:|---|
| Time | `O(n)` worst case | At most about `n / 2` character pairs are compared. |
| Auxiliary space | `O(1)` | Only two indexes and a Boolean are needed when checking the original string directly. |

Best case is `O(1)` when the first pair differs. Worst case occurs when all relevant pairs match or a mismatch appears near the center.

If you first normalize the text into a new string—for example, removing punctuation and changing case—normalization may require `O(n)` time and `O(n)` extra space.

### D. Count Vowels

Algorithm: traverse every character and check whether it is one of the five English vowels.

| Resource | Complexity | Reason |
|---|---:|---|
| Time | `O(n)` | Each character is checked once. |
| Auxiliary space | `O(1)` | Only a counter and a few local variables are needed. |

### E. Count Lowercase English-Letter Frequencies

Algorithm: create an integer array of length `26`, then traverse the string and increment the mapped index for each lowercase letter.

| Resource | Complexity | Reason |
|---|---:|---|
| Time | `O(n)` | Each input character is processed once. |
| Auxiliary space | `O(1)` with respect to input length | The frequency array always has 26 entries. |

This is constant auxiliary space only because the supported alphabet has a fixed size of 26. A frequency map for arbitrary distinct characters may use up to `O(n)` space.

## 3. Quick Comparison

| Problem | Time | Auxiliary Space |
|---|---:|---:|
| Traverse a string | `O(n)` | `O(1)` |
| Reverse using `char[]` | `O(n)` | `O(n)` |
| Reverse using `StringBuilder` | `O(n)` | `O(n)` |
| Palindrome check, no normalization | `O(n)` worst case | `O(1)` |
| Count vowels | `O(n)` | `O(1)` |
| Lowercase `a`–`z` frequency | `O(n)` | `O(1)` fixed 26-entry array |
| Compare two strings | `O(n)` worst case | `O(1)` |

## 4. Complexity Rules to Remember

- A single `charAt(i)` is `O(1)`; visiting every character is `O(n)`.
- Two pointers moving inward still give `O(n)` time, because each pointer moves at most `n` steps in total.
- Creating arrays or strings proportional to the input length generally requires `O(n)` space and time.
- Repeated immutable-string concatenation in a loop can lead to quadratic total copying in common patterns. Prefer `StringBuilder` for repeated appends.
- State the assumptions: alphabet size, whether normalization occurs, and whether output storage counts as auxiliary space.
