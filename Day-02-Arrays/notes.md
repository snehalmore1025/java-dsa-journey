# Day 2 — Complexity Analysis

## 1. What Is Time Complexity?

Time complexity describes how an algorithm's running time grows as the input size increases.

Let `n` represent the number of elements in an array.

## 2. What Is Auxiliary Space Complexity?

Auxiliary space measures the additional memory an algorithm uses, excluding the input array itself.

## 3. Array Operations

| Operation | Time Complexity | Auxiliary Space |
|---|---|---|
| Access an element by index | O(1) | O(1) |
| Forward traversal | O(n) | O(1) |
| Reverse traversal | O(n) | O(1) |
| Linear search — best case | O(1) | O(1) |
| Linear search — worst case | O(n) | O(1) |
| Frequency counting | O(n) | O(1) |
| In-place reversal | O(n) | O(1) |
| Maximum and minimum in one traversal | O(n) | O(1) |
| Second-largest in one traversal | O(n) | O(1) |
| Copy an array of length n | O(n) | O(n) |

## 4. Understanding the Complexity

### O(1) — Constant time

The operation takes a constant amount of work regardless of the array size.

Example:

```java
int value = arr[0];
```

### O(n) — Linear time

The number of operations grows approximately in proportion to the number of elements.

Example:

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

### Best case and worst case

Linear search has a best-case time complexity of O(1) when the first element matches the target. Its worst-case time complexity is O(n) when the target is last or absent.

## 5. In-Place Algorithms

An in-place algorithm modifies the existing array rather than allocating another array proportional to the input size.

For example, two-pointer reversal uses a fixed number of extra variables, so its auxiliary space complexity is O(1).

Copying an array into a separate array requires O(n) auxiliary space.

## 6. Important Notes

- Reading an array element by index takes O(1) time.
- A single complete traversal takes O(n) time.
- Two nested loops may take O(n²) time when each loop iterates over the input.
- Creating an additional array of length n requires O(n) extra space.
- Complexity describes growth as input size increases; it is not an exact measurement of seconds.
