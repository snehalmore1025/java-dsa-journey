# Day 3 — Java Strings

## 1. What Is a String?

A `String` is a sequence of characters. In Java, `String` is a class in `java.lang`.

```java
String name = "Snehal";
String language = new String("Java");
```

Strings use **zero-based indexing**:
- First character: index `0`
- Second character: index `1`
- Last character: index `length() - 1`

```java
String word = "Java";
System.out.println(word.length()); // 4
System.out.println(word.charAt(0)); // J
System.out.println(word.charAt(3)); // a
```

Calling `charAt()` with an index below `0` or at least `length()` throws `StringIndexOutOfBoundsException`.

## 2. String Immutability

Strings are **immutable**: after a `String` object is created, its character sequence cannot be changed. Methods such as `toUpperCase()` and `replace()` return a result; they do not modify the original object.

```java
String text = "java";
text.toUpperCase();

System.out.println(text); // java

text = text.toUpperCase();
System.out.println(text); // JAVA
```

The second assignment makes `text` refer to the returned string. It does not mutate the original object.

## 3. Comparing Strings

### `equals()`

Checks whether two strings contain the same sequence of characters.

```java
String a = new String("java");
String b = new String("java");

System.out.println(a.equals(b)); // true
```

### `==`

For reference types, `==` checks whether both references point to the same object, not whether the text is equal.

```java
String a = new String("java");
String b = new String("java");

System.out.println(a == b);      // false
System.out.println(a.equals(b)); // true
```

### String pool

Java can reuse string literals from the string pool.

```java
String a = "java";
String b = "java";

System.out.println(a == b); // usually true for these identical literals
```

For text comparison, use `equals()` rather than relying on `==`.

### Other comparison methods

```java
"JAVA".equalsIgnoreCase("java"); // true
"apple".compareTo("banana");    // negative value
```

`compareTo()` compares lexicographically and returns a negative value, zero, or a positive value depending on the comparison. Do not assume it returns exactly `-1` or `1`.

## 4. Common String Methods

| Method | Purpose | Example |
|---|---|---|
| `length()` | Number of UTF-16 code units | `"Java".length()` → `4` |
| `charAt(i)` | Character at index `i` | `"Java".charAt(1)` → `'a'` |
| `substring(begin)` | Text from `begin` to end | `"Java".substring(2)` → `"va"` |
| `substring(begin, end)` | Text from `begin` inclusive to `end` exclusive | `"Java".substring(1, 3)` → `"av"` |
| `contains(s)` | Whether the text contains a sequence | `"java".contains("av")` → `true` |
| `indexOf(x)` | First matching index, or `-1` | `"banana".indexOf('a')` → `1` |
| `lastIndexOf(x)` | Last matching index, or `-1` | `"banana".lastIndexOf('a')` → `5` |
| `startsWith(s)` | Whether text begins with a prefix | `"Java".startsWith("Ja")` → `true` |
| `endsWith(s)` | Whether text ends with a suffix | `"Java".endsWith("va")` → `true` |
| `replace(old, new)` | Replaces matching characters/sequences | `"banana".replace('a', 'o')` → `"bonono"` |
| `toUpperCase()` | Returns uppercase text | `"java".toUpperCase()` → `"JAVA"` |
| `toLowerCase()` | Returns lowercase text | `"JAVA".toLowerCase()` → `"java"` |
| `trim()` | Removes leading/trailing characters at or below U+0020 | `" hi ".trim()` → `"hi"` |
| `isEmpty()` | Whether length is zero | `"".isEmpty()` → `true` |
| `isBlank()` | Whether empty or whitespace-only (Java 11+) | `"  ".isBlank()` → `true` |
| `split(regex)` | Splits using a regular expression | `"a,b".split(",")` |
| `toCharArray()` | Copies characters to a `char[]` | `"cat".toCharArray()` |

`substring(begin, end)` uses an exclusive end index. For example, `"coding".substring(1, 4)` returns `"odi"`.

`split()` accepts a regular expression, not just a literal separator. To split on a dot, escape it for the regular expression and Java string literal:

```java
String[] parts = "file.txt".split("\\.");
```

## 5. Traversing a String

### Forward traversal

```java
String text = "Java";

for (int i = 0; i < text.length(); i++) {
    System.out.println(text.charAt(i));
}
```

The loop starts at index `0` and stops before `text.length()`.

### Backward traversal

```java
String text = "Java";

for (int i = text.length() - 1; i >= 0; i--) {
    System.out.println(text.charAt(i));
}
```

Start at the last valid index, `length() - 1`, and decrease `i` until it reaches `0`.

## 6. StringBuilder

Repeated concatenation in a loop can create many intermediate `String` objects because strings are immutable. `StringBuilder` provides a mutable character sequence and is useful when constructing text repeatedly.

```java
StringBuilder result = new StringBuilder();
result.append("Java");
result.append(" ");
result.append("DSA");

System.out.println(result.toString()); // Java DSA
```

Useful methods:
- `append(value)` — adds to the end.
- `insert(index, value)` — inserts at an index.
- `delete(start, end)` — deletes a range; `end` is exclusive.
- `reverse()` — reverses the sequence.
- `length()` — returns the current length.
- `charAt(index)` — reads a character.
- `setCharAt(index, ch)` — replaces a character.
- `toString()` — creates a `String` representation.

Example: reverse a string.

```java
String text = "hello";
String reversed = new StringBuilder(text).reverse().toString();
System.out.println(reversed); // olleh
```

## 7. Conversions

### String to character array

```java
String text = "hello";
char[] letters = text.toCharArray();
```

### Character array to String

```java
char[] letters = {'J', 'a', 'v', 'a'};
String text = new String(letters);
```

### String to integer

```java
int number = Integer.parseInt("123");
```

The input must be a valid integer representation; otherwise `NumberFormatException` is thrown.

### Integer to String

```java
int number = 123;
String text = String.valueOf(number);
```

### Digit character to numeric value

```java
char ch = '7';
int digit = ch - '0'; // 7
```

Use `ch - '0'` only when `ch` is a decimal digit character from `'0'` to `'9'`.

## 8. Core String DSA Patterns

### A. Reverse a String

Use two pointers or `StringBuilder`.

```java
String text = "hello";
char[] chars = text.toCharArray();

int left = 0;
int right = chars.length - 1;

while (left < right) {
    char temp = chars[left];
    chars[left] = chars[right];
    chars[right] = temp;

    left++;
    right--;
}

String reversed = new String(chars);
```

Two-pointer idea: swap the outer characters, then move inward.

### B. Check a Palindrome

A palindrome reads the same forward and backward.

```java
String text = "level";
int left = 0;
int right = text.length() - 1;
boolean palindrome = true;

while (left < right) {
    if (text.charAt(left) != text.charAt(right)) {
        palindrome = false;
        break;
    }

    left++;
    right--;
}

System.out.println(palindrome);
```

This version is case-sensitive and considers spaces and punctuation. Normalize the string first if the problem asks to ignore case or non-alphanumeric characters.

### C. Count Vowels

```java
String text = "education";
int vowels = 0;

for (int i = 0; i < text.length(); i++) {
    char ch = Character.toLowerCase(text.charAt(i));

    if (ch == 'a' || ch == 'e' || ch == 'i' ||
        ch == 'o' || ch == 'u') {
        vowels++;
    }
}
```

This checks the five English vowel letters and is not a complete vowel classifier for every language.

### D. Count Character Frequency

For lowercase English letters only:

```java
String text = "banana";
int[] frequency = new int[26];

for (int i = 0; i < text.length(); i++) {
    char ch = text.charAt(i);

    if (ch >= 'a' && ch <= 'z') {
        frequency[ch - 'a']++;
    }
}
```

`ch - 'a'` maps `'a'` to index `0`, `'b'` to index `1`, and `'z'` to index `25`. This method needs a different strategy if the input can contain uppercase letters, punctuation, or arbitrary Unicode characters.

## 9. Complexity and Problem-Solving Notes

Let `n` be the string length.

- Reading `length()` is constant time.
- Reading a character with `charAt(i)` is constant time.
- Traversing all characters is linear time, `O(n)`.
- Reversing by swapping a character array takes `O(n)` time and `O(n)` extra space for the array.
- Checking a palindrome with two pointers takes `O(n)` time in the worst case and `O(1)` auxiliary space when checking the original string directly.
- Building a result with `StringBuilder.append()` is typically efficient; repeated appends take amortized linear time in the total output size.
- Comparing strings can take up to `O(n)` time when many leading characters match.
- Creating transformed strings such as uppercase/lowercase or a substring result may require work proportional to the output length; avoid assuming every string method is `O(1)`.

## 10. Common Mistakes

1. Using `==` instead of `equals()` to compare text.
2. Forgetting that indexes begin at `0`.
3. Using `i <= text.length()` and then accessing an invalid index.
4. Assuming the end index of `substring(begin, end)` is included.
5. Expecting a String method to mutate the original string.
6. Using `split(".")` to split on a literal dot. A dot is a regex wildcard; use `split("\\.")`.
7. Repeatedly concatenating strings inside a large loop instead of considering `StringBuilder`.
8. Assuming a 26-element frequency array handles every possible character.
9. Forgetting that a simple palindrome check is case-sensitive and includes spaces/punctuation.
10. Using `charAt()` without ensuring the index is valid.

## 11. Practice Checklist

- [ ] Reverse a string.
- [ ] Check whether a string is a palindrome.
- [ ] Count vowels and consonants.
- [ ] Count the frequency of each lowercase English letter.
- [ ] Explain the difference between `==` and `equals()`.
- [ ] Explain why `StringBuilder` is useful for repeated modifications.
