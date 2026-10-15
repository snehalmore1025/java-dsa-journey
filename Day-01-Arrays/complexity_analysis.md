# Day 1 — Time and Space Complexity

## 1. Array Traversal

```java
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

**Time Complexity: O(n)**
- The loop visits every element once.
- For `n` elements, it runs `n` times.

**Space Complexity: O(1)**
- Only the loop variable `i` is used.
- No extra array or collection is created.

---

## 2. Array Sum

```java
int sum = 0;
for (int number : numbers) {
    sum += number;
}
```

**Time Complexity: O(n)**
- Every element is added once.
- `n` elements require `n` iterations.

**Space Complexity: O(1)**
- Only a fixed number of variables, such as `sum` and `number`, are used.
- Memory usage does not grow with the array length.

---

## 3. Finding Maximum and Minimum

```java
int max = numbers[0];
int min = numbers[0];

for (int i = 1; i < numbers.length; i++) {
    if (numbers[i] > max) max = numbers[i];
    if (numbers[i] < min) min = numbers[i];
}
```

**Time Complexity: O(n)**
- Each remaining element is checked once.
- Maximum and minimum are found in one traversal.

**Space Complexity: O(1)**
- Only `max`, `min`, and `i` are maintained.
- No additional data structure is created.

*Note: The array must be non-empty.*

---

## 4. Counting Even Numbers

```java
int count = 0;

for (int number : numbers) {
    if (number % 2 == 0) {
        count++;
    }
}
```

**Time Complexity: O(n)**
- Every element is checked once.
- Each check takes constant time.

**Space Complexity: O(1)**
- Only a counter and a loop variable are used.
- Even numbers are counted, not stored separately.

---

## 5. Binary Search

**Time Complexity: O(log n)**
- Each comparison eliminates approximately half the remaining search space.
- For 16 elements, the search space shrinks roughly as `16 → 8 → 4 → 2 → 1`.

**Space Complexity: O(1)**
- The iterative version uses `left`, `right`, and `mid`.
- No additional array is created.

*Precondition: The array must be sorted.*

---

## 6. Creating a New Array

```java
int[] result = new int[n];

for (int i = 0; i < n; i++) {
    result[i] = numbers[i] * 2;
}
```

**Time Complexity: O(n)**
- The result array is created and all `n` elements are processed.

**Space Complexity: O(n)**
- A new array of `n` elements is allocated.
- More input elements require more additional memory.

---

## Complexity Summary

| Operation | Time Complexity | Auxiliary Space |
|---|---|---|
| Array traversal | O(n) | O(1) |
| Array sum | O(n) | O(1) |
| Maximum and minimum | O(n) | O(1) |
| Count even numbers | O(n) | O(1) |
| Iterative binary search | O(log n) | O(1) |
| Create a new array | O(n) | O(n) |

## Key Takeaway

- **Time complexity:** How the amount of work grows with input size.
- **Space complexity:** How much additional memory the solution uses.
- A single loop over `n` elements is usually O(n).
- A fixed number of variables uses O(1) auxiliary space.
- An additional array of `n` elements uses O(n) auxiliary space.