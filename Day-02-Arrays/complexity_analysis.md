# Day 2 — Array Complexity Analysis

## 1. Time Complexity

Time complexity describes how the running time of an algorithm grows as the input size increases.

Let `n` represent the number of elements in an array.

## 2. Auxiliary Space Complexity

Auxiliary space measures the extra memory an algorithm uses, excluding the input array itself.

## 3. Complexity of Array Operations

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
| Copy an array of length `n` | O(n) | O(n) |

## 4. Understanding Common Complexities

### O(1) — Constant time

The work does not grow with the array size for a single operation.

```java
int value = arr[0];
```

### O(n) — Linear time

The algorithm processes each element once.

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

### Best-case and worst-case complexity

Linear search has:

- **Best case:** O(1), when the first element matches.
- **Worst case:** O(n), when the target is last or absent.

## 5. In-Place Algorithms

An in-place algorithm modifies the original array rather than allocating another array proportional to its length.

Two-pointer reversal uses only a fixed number of extra variables, so its auxiliary space is O(1).

Copying an array into a separate array requires O(n) additional space.

## 6. Key Observations

1. Array access by index takes O(1) time.
2. A complete traversal takes O(n) time.
3. Frequency counting generally examines every element.
4. Two nested loops may take O(n²) time when both iterate over the input.
5. Creating an extra array of length `n` requires O(n) auxiliary space.
6. Complexity describes growth as input size increases, not an exact duration in seconds.
