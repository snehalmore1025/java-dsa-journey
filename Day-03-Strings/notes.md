# Day 3 — Java Strings Notes

## 1. Introduction to Strings

A **String** is a sequence of characters. In Java, `String` is a class belonging to the `java.lang` package.

```java
String name = "Snehal";
String language = new String("Java");
```

### Key points
- A String stores text, including letters, digits, spaces, and symbols.
- Strings are objects, not primitive data types.
- String indexing starts from `0`.
- The last valid index is `length() - 1`.
- Strings are immutable.

```java
String text = "Java";

System.out.println(text.length()); // 4
System.out.println(text.charAt(0)); // J
System.out.println(text.charAt(3)); // a
```

## 2. String Immutability

**Immutability** means an object's contents cannot be changed after it is created.

Java Strings are immutable. Methods that produce modified text return a new String rather than changing the original String.

```java
String text = "java";
text.toUpperCase();

System.out.println(text); // java
```

The original value remains unchanged because the returned String was not assigned.

```java
String text = "java";
text = text.toUpperCase();

System.out.println(text); // JAVA
```

Here, the variable `text` refers to the new String.

### Advantages of immutability
- Makes String values predictable.
- Allows safe reuse of String literals.
- Supports the String pool mechanism.
- Helps prevent unintended modifications.

## 3. String Pool

The **String pool** is a special area of Java memory where String literals can be reused.

```java
String a = "Java";
String b = "Java";

System.out.println(a == b); // true
```

Both variables refer to the same pooled literal in this example.

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b);      // false
System.out.println(a.equals(b)); // true
```

The `new` keyword creates distinct String objects in this example.

### Remember
- String literals can share pooled objects.
- `==` compares object references.
- `equals()` compares String contents.
- Use `equals()` when comparing text.

## 4. Comparing Strings

### `equals()`

Checks whether two Strings contain the same characters.

```java
System.out.println("Java".equals("Java")); // true
```

### `equalsIgnoreCase()`

Compares Strings without distinguishing uppercase and lowercase letters.

```java
System.out.println("JAVA".equalsIgnoreCase("java")); // true
```

### `==`

Checks whether two object references point to the same object.

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b); // false
```

### `compareTo()`

Compares Strings lexicographically, based on their character values.

```java
System.out.println("apple".compareTo("banana")); // negative
System.out.println("java".compareTo("java"));    // 0
System.out.println("zebra".compareTo("apple"));   // positive
```

- Negative result: the first String comes before the second.
- Zero: the Strings compare as equal.
- Positive result: the first String comes after the second.

The result is not necessarily exactly `-1`, `0`, or `1`.

## 5. Important String Methods

| Method | Purpose |
|---|---|
| `length()` | Returns the String length |
| `charAt(index)` | Returns the character at an index |
| `substring(begin)` | Returns text from an index to the end |
| `substring(begin, end)` | Returns a range; ending index is excluded |
| `equals(text)` | Compares String contents |
| `equalsIgnoreCase(text)` | Compares without case sensitivity |
| `contains(text)` | Checks whether a sequence is present |
| `indexOf(value)` | Returns the first matching index |
| `lastIndexOf(value)` | Returns the last matching index |
| `startsWith(prefix)` | Checks the beginning of a String |
| `endsWith(suffix)` | Checks the ending of a String |
| `replace(old, new)` | Replaces matching characters or sequences |
| `toUpperCase()` | Converts text to uppercase |
| `toLowerCase()` | Converts text to lowercase |
| `trim()` | Removes certain leading and trailing characters |
| `isEmpty()` | Checks whether the length is zero |
| `isBlank()` | Checks whether empty or whitespace-only; Java 11+ |
| `split(regex)` | Splits text using a regular expression |
| `toCharArray()` | Converts a String to a character array |

### Examples

```java
String text = "Programming";

System.out.println(text.length());          // 11
System.out.println(text.charAt(0));         // P
System.out.println(text.substring(0, 4));   // Prog
System.out.println(text.contains("gram"));  // true
System.out.println(text.indexOf('g'));      // 3
System.out.println(text.endsWith("ing"));   // true
```

The ending index of `substring(begin, end)` is exclusive.

```java
String text = "banana";

System.out.println(text.replace('a', 'o')); // bonono
System.out.println(text);                  // banana
```

`replace()` returns a new String; it does not modify the original.

### `split()`

The `split()` method uses a regular expression.

```java
String colors = "red,green,blue";
String[] parts = colors.split(",");
```

A dot (`.`) is a special regular-expression character. To split on a literal dot:

```java
String[] parts = "file.txt".split("\\.");
```

### `indexOf()` and `lastIndexOf()`

Both return `-1` when the requested character or sequence is not found.

```java
System.out.println("Java".indexOf('z')); // -1
```

## 6. String Traversal

**Traversal** means visiting characters one by one.

A String can be traversed from beginning to end using a loop.

```java
String text = "Java";

for (int i = 0; i < text.length(); i++) {
    System.out.println(text.charAt(i));
}
```

Backward traversal starts from the last valid index.

```java
for (int i = text.length() - 1; i >= 0; i--) {
    System.out.println(text.charAt(i));
}
```

### Important indexing rule

Correct:

```java
i < text.length()
```

Incorrect:

```java
i <= text.length()
```

The incorrect condition can cause an index-out-of-bounds exception because `text.length()` is not a valid character index.

## 7. String and Character Arrays

A String can be converted to a character array using `toCharArray()`.

```java
String text = "Java";
char[] characters = text.toCharArray();
```

A character array can be converted back to a String.

```java
char[] characters = {'J', 'a', 'v', 'a'};
String text = new String(characters);
```

### Difference between String and `char[]`

- A String is immutable.
- A character array is mutable.
- Individual elements of a character array can be modified.
- Character arrays are useful when an algorithm requires direct character modification.

## 8. StringBuilder

`StringBuilder` is a mutable sequence of characters. It is useful when text needs to be built or modified repeatedly.

```java
StringBuilder result = new StringBuilder();

result.append("Java");
result.append(" ");
result.append("DSA");

System.out.println(result.toString()); // Java DSA
```

### Important StringBuilder methods

| Method | Purpose |
|---|---|
| `append(value)` | Adds content to the end |
| `insert(index, value)` | Inserts content at an index |
| `delete(start, end)` | Deletes a range; ending index is excluded |
| `reverse()` | Reverses the sequence |
| `length()` | Returns the current length |
| `charAt(index)` | Reads a character |
| `setCharAt(index, ch)` | Replaces a character |
| `toString()` | Converts the builder to a String |

### String vs StringBuilder

| String | StringBuilder |
|---|---|
| Immutable | Mutable |
| Suitable for storing text | Useful for repeated text modification |
| Changed text requires a returned String | Methods such as `append()` modify the builder |
| Repeated concatenation can create intermediate objects | Often more efficient for repeated concatenation |

## 9. String and Number Conversions

### String to integer

```java
String text = "123";
int number = Integer.parseInt(text);
```

If the String does not represent a valid integer, `NumberFormatException` is thrown.

### Integer to String

```java
int number = 123;
String text = String.valueOf(number);
```

### Digit character to integer

```java
char ch = '7';
int digit = ch - '0';
```

This works for decimal digit characters from `'0'` to `'9'`.

### Integer digit to character

```java
int digit = 7;
char ch = (char) (digit + '0');
```

This example assumes the integer is between `0` and `9`.

## 10. General String DSA Concepts

### Two-pointer technique

The two-pointer technique uses two indexes to process a sequence.

```java
int left = 0;
int right = text.length() - 1;
```

The pointers can move toward each other or through the sequence according to the algorithm's conditions.

This technique can reduce unnecessary repeated processing.

### Character mapping

Characters can be mapped to array indexes using character arithmetic.

For lowercase English letters:

```java
int index = ch - 'a';
```

The mapping is:

- `'a'` → index `0`
- `'b'` → index `1`
- `'c'` → index `2`
- `'z'` → index `25`

This mapping applies to lowercase English letters only.

### Character normalization

Text may need to be normalized before comparison. Common examples include converting letters to lowercase or deciding how spaces and punctuation should be treated.

Always follow the requirements of the algorithm. Do not remove spaces or ignore case unless the task specifies it.

## 11. Time and Space Complexity of String Operations

Let `n` be the number of characters in the input String.

| Operation | Time complexity | Additional space |
|---|---|---|
| `length()` | `O(1)` | `O(1)` |
| `charAt(index)` | `O(1)` | `O(1)` |
| Traverse all characters | `O(n)` | `O(1)` |
| Compare two Strings | `O(n)` worst case | `O(1)` |
| Create a character array from a String | `O(n)` | `O(n)` |
| Build a String using a StringBuilder | Depends on appended content; typically `O(n)` total for `n` characters | `O(n)` |
| Use a fixed 26-element array | `O(1)` initialization | `O(1)` |
| Search for a character or substring | Depends on the search; may be `O(n)` or more for substring search | Usually `O(1)` auxiliary space |

### Complexity principles

- Processing each character once generally takes `O(n)` time.
- A fixed-size array uses `O(1)` space relative to input length.
- A character array storing all input characters uses `O(n)` space.
- Creating a new String proportional to the input length generally requires `O(n)` space.
- A comparison may stop at the first mismatch, but the worst case can examine all characters.

## 12. Common Mistakes

1. Using `==` instead of `equals()` to compare String contents.
2. Forgetting that String indexes start at `0`.
3. Accessing `charAt(text.length())`.
4. Forgetting that `substring(begin, end)` excludes the ending index.
5. Expecting String methods to modify the original String.
6. Using `split(".")` to split on a literal dot instead of `split("\\.")`.
7. Using repeated String concatenation in a large loop when `StringBuilder` is more suitable.
8. Assuming a 26-element array supports every possible character.
9. Ignoring case, spaces, or punctuation without checking the requirements.
10. Forgetting to consider empty Strings.
11. Assuming `compareTo()` returns only `-1`, `0`, or `1`.
12. Using `Integer.parseInt()` without considering invalid input.

## 13. Day 3 Revision Checklist

- [ ] Understand String creation and indexing.
- [ ] Explain String immutability.
- [ ] Understand the String pool.
- [ ] Distinguish `==`, `equals()`, and `equalsIgnoreCase()`.
- [ ] Understand `compareTo()`.
- [ ] Know the important String methods.
- [ ] Understand forward and backward traversal.
- [ ] Convert between String and `char[]`.
- [ ] Understand StringBuilder and its methods.
- [ ] Convert between Strings and numbers.
- [ ] Understand the two-pointer technique and character mapping.
- [ ] Explain time and space complexity.
- [ ] Avoid common String-related errors.
