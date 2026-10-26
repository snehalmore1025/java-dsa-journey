# LeetCode 74 — Search a 2D Matrix

## 📌 Problem
Given an `m × n` matrix where:
- Each row is sorted in ascending order.
- The first element of each row is greater than the last element of the previous row.

Return `true` if the target exists in the matrix; otherwise, return `false`.

## 💡 Approach: Binary Search

Since the matrix follows a sorted order, we can treat it like a **one-dimensional sorted array** and apply binary search without actually converting it into another array.

### Steps
1. Calculate the number of rows and columns.
2. Set `left = 0` and `right = rows * cols - 1`.
3. Calculate the middle index using `mid = left + (right - left) / 2`.
4. Convert the one-dimensional index into matrix coordinates:
   - `row = mid / cols`
   - `col = mid % cols`
5. Compare `matrix[row][col]` with the target:
   - If equal, return `true`.
   - If smaller, search the right half.
   - If greater, search the left half.
6. If the target is not found, return `false`.

## 🧠 Key Concept

For a matrix with 4 columns:

- `row = mid / 4` gives the row index.
- `col = mid % 4` gives the column index.

Integer division (`/`) finds the row, while the remainder operator (`%`) finds the column.

## 💻 Java Solution

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
```

## 🧪 Example

**Input:**
```text
matrix = [[1,3,5,7],
          [10,11,16,20],
          [23,30,34,60]]
target = 16
```

**Output:**
```text
true
```

**Explanation:** The target `16` is located at `matrix[1][2]`.

## ⏱️ Complexity Analysis

- **Time Complexity:** `O(log(m × n))` — binary search eliminates half of the remaining elements in each iteration.
- **Space Complexity:** `O(1)` — only a constant number of variables are used.

## 📚 What I Learned

- Applying binary search to a 2D matrix.
- Converting a one-dimensional index into row and column indices.
- Using integer division (`/`) and remainder (`%`).
- Reducing search time by eliminating half of the search space in each iteration.

## ✅ Status
- [x] Problem solved
- [x] Binary search approach understood
- [x] Dry run completed
