# Day 2 — Java DSA: Array Operations

**Language:** Java  
**Topics:** Array Traversal, Linear Search, Frequency Counting, Array Reversal, Maximum and Minimum, Second-Largest Element, Array Updating and Copying

## 1. Array Traversal

Array traversal means visiting each element of an array, one by one, to perform an operation.

Example:

```java
int[] arr = {10, 20, 30, 40, 50};

for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

Output:

```text
10
20
30
40
50
```

### Understanding the loop

- `int i = 0`: starts from the first index.
- `i < arr.length`: continues while the index is valid.
- `i++`: increases the index after each iteration.
- `arr[i]`: accesses the element at index `i`.

If an array has length `n`, its valid indices are `0` through `n - 1`.

### Reverse traversal

```java
for (int i = arr.length - 1; i >= 0; i--) {
    System.out.println(arr[i]);
}
```

This visits the elements from the last index to the first.

## 2. Linear Search

Linear search checks elements one by one until the target is found.

Example:

```java
int[] arr = {12, 7, 25, 9, 18};
int target = 25;
int index = -1;

for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        index = i;
        break;
    }
}

System.out.println(index);
```

Output:

```text
2
```

### Algorithm

1. Start at index zero.
2. Compare the current element with the target.
3. If they match, store the index and stop searching.
4. If the target is absent, return or retain `-1`.

`break` terminates the loop immediately.

## 3. Frequency Counting

Frequency is the number of times a value occurs in an array.

Example:

```java
int[] arr = {2, 5, 2, 7, 2, 5};
int target = 2;
int count = 0;

for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        count++;
    }
}

System.out.println(count);
```

Output:

```text
3
```

### Important distinction

Linear search may stop when it finds the target. Frequency counting must usually examine the entire array to count every occurrence.

## 4. Reversing an Array In-Place

Reversing an array means changing the order of its elements.

Example:

```text
Original: [10, 20, 30, 40, 50]
Reversed: [50, 40, 30, 20, 10]
```

### Two-pointer approach

```java
int[] arr = {10, 20, 30, 40, 50};

int left = 0;
int right = arr.length - 1;

while (left < right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;

    left++;
    right--;
}
```

### Explanation

- `left` begins at the first index.
- `right` begins at the last index.
- `temp` temporarily stores a value during swapping.
- After each swap, `left` moves right and `right` moves left.
- The loop stops when the pointers meet or cross.

The original array is modified without creating another array.

## 5. Finding Maximum and Minimum

Maximum is the largest value, and minimum is the smallest value in an array.

Example:

```text
Array: [12, 35, 1, 10, 34]
Maximum: 35
Minimum: 1
```

A common approach is to initialise both variables with the first element and compare the remaining elements.

```java
int max = arr[0];
int min = arr[0];

for (int i = 1; i < arr.length; i++) {
    if (arr[i] > max) {
        max = arr[i];
    }

    if (arr[i] < min) {
        min = arr[i];
    }
}
```

This approach assumes the array is not empty. An empty array must be handled separately.

## 6. Finding the Second-Largest Distinct Element

The second-largest distinct element is the largest value strictly smaller than the maximum.

Example:

```text
Array: [12, 35, 1, 10, 34, 35]
Largest: 35
Second-largest distinct: 34
```

The second-largest distinct element is not necessarily the second element in the array.

### Key idea

Maintain two variables:

- `largest`: the greatest value found so far.
- `secondLargest`: the greatest distinct value below `largest`.

When a new largest value is found, the previous largest may become the second-largest.

Consider edge cases:

- All elements are equal.
- The array contains only one element.
- The maximum occurs multiple times.
- No second-largest distinct value exists.

The program should handle these cases explicitly.

## 7. Updating and Copying Arrays

### Updating an element

```java
int[] arr = {10, 20, 30};
arr[1] = 99;
```

Result:

```text
[10, 99, 30]
```

### Copying with a loop

```java
int[] original = {4, 8, 12};
int[] copy = new int[original.length];

for (int i = 0; i < original.length; i++) {
    copy[i] = original[i];
}
```

The `copy` array is a separate array. Changing an element in `copy` does not change the corresponding element in `original`.

## 8. Important Java Concepts

| Expression | Meaning |
|---|---|
| `arr.length` | Number of elements |
| `arr[i]` | Element at index `i` |
| `i++` | Increase `i` by one |
| `i--` | Decrease `i` by one |
| `count++` | Increase the counter |
| `break` | Exit the loop |
| `left < right` | Continue while pointers have not met |

## 9. Summary

| Operation | Main idea |
|---|---|
| Traversal | Visit every element |
| Linear search | Find a target |
| Frequency counting | Count all matches |
| Reversal | Swap elements from both ends |
| Maximum/minimum | Track extreme values |
| Second-largest | Track two distinct values |
| Copying | Transfer values to a separate array |

These operations form the foundation for solving array problems in Java and on LeetCode.
