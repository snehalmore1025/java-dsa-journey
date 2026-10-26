# LeetCode 278 — First Bad Version

## Problem Statement

You are given `n` versions numbered from `1` to `n`. Once a version is bad, all subsequent versions are also bad.

You are provided with an API `isBadVersion(version)` that returns:

- `true` if the version is bad.
- `false` if the version is good.

Return the first bad version while minimizing the number of API calls.

**LeetCode:** [278. First Bad Version](https://leetcode.com/problems/first-bad-version/)

## Approach: Binary Search

Since all versions after the first bad version are also bad, we can use binary search to find the first bad version efficiently.

### Algorithm

1. Initialize `left = 1` and `right = n`.
2. While `left < right`:
   - Calculate the middle version:
     `mid = left + (right - left) / 2`
   - If `isBadVersion(mid)` returns `true`, the first bad version is at `mid` or before it. Set `right = mid`.
   - Otherwise, the first bad version must be after `mid`. Set `left = mid + 1`.
3. When `left == right`, return `left`.

### Java Solution

```java
/* The isBadVersion API is defined in VersionControl.
   boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
```

## Dry Run

**Input:** `n = 5`

**First bad version:** `4`

| Step | Left | Right | Mid | `isBadVersion(mid)` | Action |
|---|---:|---:|---:|---|---|
| 1 | 1 | 5 | 3 | `false` | `left = 4` |
| 2 | 4 | 5 | 4 | `true` | `right = 4` |

Now `left == right == 4`, so the answer is `4`.

## Understanding the Mid Calculation

We use:

```java
int mid = left + (right - left) / 2;
```

For example, if `left = 1` and `right = 5`:

```text
mid = 1 + (5 - 1) / 2
mid = 1 + 4 / 2
mid = 1 + 2
mid = 3
```

Java performs integer division, so any fractional part is discarded.

This formula is preferred over `(left + right) / 2` because it avoids potential integer overflow when `left + right` exceeds the `int` range.

## Complexity Analysis

- **Time Complexity:** `O(log n)` — binary search reduces the search range by approximately half each iteration.
- **Auxiliary Space Complexity:** `O(1)` — only a constant number of variables are used.

## Key Learning

- Apply binary search to a monotonic sequence of good and bad versions.
- When `mid` is bad, use `right = mid`, not `mid - 1`, because `mid` could be the first bad version.
- When `mid` is good, use `left = mid + 1`.
- The loop condition `left < right` ensures the search converges on one version.

## Local Testing Note

LeetCode provides `VersionControl` and `isBadVersion()` automatically. For local testing in VS Code, a separate mock `VersionControl` class is required. Do not include that mock class in the LeetCode submission.
