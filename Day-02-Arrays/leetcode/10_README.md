# LeetCode 374 — Guess Number Higher or Lower

## 📌 Problem Statement

We are given an integer `n`. A hidden number is selected from the range `1` to `n`.

Our task is to find the hidden number using the provided `guess()` API.

The API returns:

- `-1` if our guess is higher than the hidden number.
- `1` if our guess is lower than the hidden number.
- `0` if our guess is correct.

## 💡 Approach: Binary Search

Binary search helps us find the hidden number efficiently by eliminating half of the remaining search range after each guess.

### Steps

1. Initialize `left = 1` and `right = n`.
2. Calculate the middle number using `mid = left + (right - left) / 2`.
3. Call `guess(mid)` and store the result in `result`.
4. If `result == 0`, return `mid` because the correct number is found.
5. If `result == -1`, the guess is too high, so update `right = mid - 1`.
6. Otherwise, the guess is too low, so update `left = mid + 1`.
7. Continue until the hidden number is found.

## 💻 Java Solution

```java
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
```

## 🧪 Example

**Input:**
```text
n = 10
picked number = 6
```

**Dry Run:**

| Iteration | Left | Right | Mid | API result | Action |
|---|---:|---:|---:|---|---|
| 1 | 1 | 10 | 5 | `1` | Search right half |
| 2 | 6 | 10 | 8 | `-1` | Search left half |
| 3 | 6 | 7 | 6 | `0` | Number found |

**Output:**
```text
6
```

## 🔍 Understanding `guess(mid)`

The `guess(mid)` function checks the middle number against the hidden number and returns feedback.

The variable `result` stores that feedback, allowing binary search to decide which half to eliminate.

On LeetCode, `GuessGame` and `guess()` are provided by the platform. For local testing in VS Code, a mock `GuessGame` class can be