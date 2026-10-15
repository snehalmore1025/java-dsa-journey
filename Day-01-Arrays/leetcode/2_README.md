# 2. Best Time to Buy and Sell Stock

## Problem Details
- **LeetCode No.:** 121
- **Difficulty:** Easy
- **Topic:** Array
- **Language:** Java
- **Approach:** Single Pass

## Problem Statement
Given an array `prices`, find the maximum profit by buying a stock on one day and selling it on a later day. If no profit is possible, return `0`.

## Example
**Input:**
```text
prices = [7, 1, 5, 3, 6, 4]
```

**Output:**
```text
5
```

**Explanation:** Buy at price `1` and sell later at price `6`.

Profit = `6 - 1 = 5`.

## Approach
1. Set `buy` to the first day's price.
2. Initialize `maxProfit` to `0`.
3. Traverse the array from the second day.
4. Calculate the profit possible by selling at the current price.
5. Update `maxProfit` if the current profit is greater.
6. Update `buy` if the current price is lower.
7. Return `maxProfit`.

## Dry Run

**Input:** `prices = [7, 1, 5, 3, 6, 4]`

Initial values: `buy = 7`, `maxProfit = 0`

| Day | Price | Buy price before update | Current profit | Max profit | Action |
|---:|---:|---:|---:|---:|---|
| 1 | 7 | 7 | — | 0 | Initialize |
| 2 | 1 | 7 | -6 | 0 | Update buy to 1 |
| 3 | 5 | 1 | 4 | 4 | Update maxProfit |
| 4 | 3 | 1 | 2 | 4 | Keep maxProfit |
| 5 | 6 | 1 | 5 | 5 | Update maxProfit |
| 6 | 4 | 1 | 3 | 5 | Keep maxProfit |

**Final answer:** `5`

## Complexity Analysis

### Time Complexity: O(n)
The array is traversed once. Each iteration performs a constant amount of work.

### Auxiliary Space Complexity: O(1)
Only a fixed number of variables (`buy`, `maxProfit`, and `currentProfit`) are used.

## What I Learned
- How to track the minimum price seen so far.
- How to calculate the profit for each selling day.
- How to maintain the maximum profit.
- Why buying must happen before selling.

## Status
- [ ] Code accepted on LeetCode
- [x] Logic understood
- [x] Dry run completed
- [x] Complexity analysed
