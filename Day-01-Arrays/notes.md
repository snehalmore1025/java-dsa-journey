
# Day 1 — DSA Fundamentals and Java Arrays

**Date:** 15 October 2026  
**Language:** Java  
**Topics:** DSA fundamentals, Big O, arrays, loops, traversal, sum, maximum, minimum, and counting.

---

## 1. What is DSA?

DSA stands for Data Structures and Algorithms.

### Data Structure
A data structure organizes and stores data so it can be accessed and processed efficiently.

Examples:
- Array
- Linked List
- Stack
- Queue
- HashMap
- Tree
- Graph
- Heap

### Algorithm
An algorithm is a finite sequence of steps used to solve a problem.

Example: To find the maximum in an array:
1. Assume the first element is the maximum.
2. Visit each remaining element.
3. If the current element is greater than the maximum, update the maximum.
4. Return the maximum.

### Why DSA matters
- Improves logical thinking.
- Helps solve programming problems.
- Helps select suitable data structures.
- Helps analyze code efficiency.
- Is commonly tested in technical interviews.

---

## 2. Complexity Analysis

Complexity analysis describes how an algorithm's resource requirements grow as the input size grows.

Let `n` represent the number of input elements.

### Time Complexity

| Complexity | Meaning | Example |
|---|---|---|
| O(1) | Constant | Access an array element by index |
| O(log n) | Logarithmic | Binary search on sorted data |
| O(n) | Linear | Traverse an array |
| O(n log n) | Linearithmic | Typical efficient comparison sorting |
| O(n²) | Quadratic | Compare all pairs using two nested loops |

These are growth-rate descriptions, not exact execution times.

### O(1): Constant Time

```java
int[] numbers = {10, 20, 30};
System.out.println(numbers[1]);
```

Accessing an element by index takes constant time in the usual array model.

### O(n): Linear Time

```java
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

Every element is visited once.

### O(n²): Quadratic Time

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + ", " + j);
    }
}
```

For `n = 5`, the inner statement executes 25 times.

### Space Complexity

Space complexity describes the memory required as the input grows.

Auxiliary space is the additional memory used by an algorithm, excluding the input when appropriate.

Example:
- Using a fixed number of variables: O(1) auxiliary space.
- Creating another array of `n` elements: O(n) additional space.

---

## 3. Java Arrays

An array stores a fixed number of elements of the same declared element type.

### Declaration

```java
int[] numbers;
```

### Creation

```java
numbers = new int[5];
```

### Initialization

```java
int[] numbers = {12, 5, 27, 8, 19};
```

### Array Indexing

Array indexing starts at zero.

For `int[] numbers = {12, 5, 27, 8, 19};`

| Index | Value |
|---:|---:|
| 0 | 12 |
| 1 | 5 |
| 2 | 27 |
| 3 | 8 |
| 4 | 19 |

If an array has length `n`, valid indexes range from `0` to `n - 1`.

### Array Length

```java
System.out.println(numbers.length);
```

`length` is a property, not a method.

### Updating an Element

```java
numbers[1] = 25;
```

This replaces the value at index 1. It does not increase the array's length.

### Important Warning

Accessing an invalid index causes an `ArrayIndexOutOfBoundsException`.

For an array of length 5, `numbers[5]` is invalid.

---

## 4. Traversing an Array

Traversal means visiting the array elements one by one.

```java
int[] numbers = {10, 20, 30};

for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

Explanation:
- `int i = 0`: start at the first index.
- `i < numbers.length`: continue while the index is valid.
- `i++`: move to the next index.
- `numbers[i]`: access the current element.

Time complexity: O(n)  
Auxiliary space: O(1)

### Enhanced For Loop

```java
for (int number : numbers) {
    System.out.println(number);
}
```

Use this when you need each element but do not need its index.

---

## 5. Sum of Array Elements

Algorithm:
1. Initialize `sum = 0`.
2. Visit each element.
3. Add the current element to `sum`.
4. Print the result.

```java
int sum = 0;

for (int number : numbers) {
    sum += number;
}
```

Time complexity: O(n)  
Auxiliary space: O(1)

---

## 6. Finding Maximum and Minimum

Initialize both values from the first array element.

```java
int max = numbers[0];
int min = numbers[0];
```

For each element:
- If it is greater than `max`, update `max`.
- If it is smaller than `min`, update `min`.

Initializing from the first element works for arrays containing negative values too.

This approach requires a non-empty array. Check the array length before accessing `numbers[0]` if empty arrays are possible.

Time complexity: O(n)  
Auxiliary space: O(1)

---

## 7. Counting Elements

Example: Count how many elements are even.

```java
int count = 0;

for (int number : numbers) {
    if (number % 2 == 0) {
        count++;
    }
}
```

The remainder operator `%` returns the remainder after division.

A number is even if `number % 2 == 0`.

Time complexity: O(n)  
Auxiliary space: O(1)

---

## 8. Dry Run: Sum, Maximum, and Minimum

Input:

`[12, 5, 27, 8, 19]`

Initial values:
- `sum = 0`
- `max = 12`
- `min = 12`

| Current value | Sum | Maximum | Minimum |
|---:|---:|---:|---:|
| Initial | 0 | 12 | 12 |
| 12 | 12 | 12 | 12 |
| 5 | 17 | 12 | 5 |
| 27 | 44 | 27 | 5 |
| 8 | 52 | 27 | 5 |
| 19 | 71 | 27 | 5 |

Output:
- Sum: 71
- Maximum: 27
- Minimum: 5

---

## 9. Common Mistakes

1. Starting an array index at 1 instead of 0.
2. Using `i <= numbers.length` instead of `i < numbers.length`.
3. Confusing array length with the last valid index.
4. Initializing maximum to 0 when all values might be negative.
5. Forgetting to update the sum inside the loop.
6. Using `numbers[0]` without checking whether the array is empty.
7. Forgetting to save or test the Java program.

---

## 10. Complexity Summary

| Operation | Time | Auxiliary Space |
|---|---|---|
| Access by index | O(1) | O(1) |
| Update by index | O(1) | O(1) |
| Traverse array | O(n) | O(1) |
| Calculate sum | O(n) | O(1) |
| Find maximum/minimum | O(n) | O(1) |
| Count elements by condition | O(n) | O(1) |

---

## 11. Day 1 Revision Questions

1. What is the difference between a data structure and an algorithm?
2. Why does Java array indexing start at zero?
3. What is the last valid index of an array of length 8?
4. What is the time complexity of visiting every array element once?
5. Why should maximum and minimum be initialized from an array element?
6. What is the difference between time complexity and auxiliary space?
7. Why can `i <= numbers.length` cause an error?
8. What is the difference between a regular `for` loop and an enhanced `for` loop?

## Day 1 Completion Goals

- Understand basic Big O notation.
- Understand array declaration, indexing, and traversal.
- Write and run basic Java array programs.
- Dry-run code without guessing.
- Explain time and auxiliary space complexity.
- Save notes and code in GitHub.
