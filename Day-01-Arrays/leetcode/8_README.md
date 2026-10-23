# Problem 8: Richest Customer Wealth

**LeetCode:** [1672 — Richest Customer Wealth](https://leetcode.com/problems/richest-customer-wealth/)  
**Topic:** Arrays, 2D Arrays, Nested Loops  
**Difficulty:** Easy  
**Language:** Java

## Problem Statement

You are given a 2D integer array `accounts`, where `accounts[i][j]` represents the money the `i`th customer has in their `j`th bank account.

The wealth of a customer is the sum of the money in all their bank accounts.

Return the maximum wealth among all customers.

## Example

**Input**
```text
accounts = [[2,8],[10,1],[4,5]]
```

**Output**
```text
11
```

**Explanation**

- Customer 1: `2 + 8 = 10`
- Customer 2: `10 + 1 = 11`
- Customer 3: `4 + 5 = 9`

The maximum wealth is `11`.

## Approach: Nested Loops

1. Initialize `maxWealth = 0`.
2. Use an outer loop to visit each customer.
3. Initialize `wealth = 0` for each new customer.
4. Use an inner loop to add all account balances for that customer.
5. If `wealth > maxWealth`, update `maxWealth`.
6. Return `maxWealth` after checking every customer.

## Java Solution

```java
class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;

            for (int j = 0; j < accounts[i].length; j++) {
                wealth += accounts[i][j];
            }

            if (wealth > maxWealth) {
                maxWealth = wealth;
            }
        }

        return maxWealth;
    }
}
```

## Dry Run

Input: `[[2,8],[10,1],[4,5]]`

| Customer (`i`) | Account balances | Wealth | `maxWealth` |
|---|---|---:|---:|
| 0 | 2, 8 | 10 | 10 |
| 1 | 10, 1 | 11 | 11 |
| 2 | 4, 5 | 9 | 11 |

**Output:** `11`

## Understanding 2D Array Indexing

- `accounts.length` gives the number of customers (rows).
- `accounts[i].length` gives the number of accounts for customer `i`.
- `accounts[i][j]` accesses the balance at row `i`, column `j`.
- Java array indexes start at `0`.

For example, `accounts[0][0]` is `2`, the first account balance of the first customer.

## Complexity Analysis

- **Time Complexity:** `O(m × n)`, where `m` is the number of customers and `n` is the number of accounts per customer.
- **Auxiliary Space Complexity:** `O(1)`, because only two integer variables are used.

## Key Takeaways

- Use nested loops to traverse a 2D array.
- Reset `wealth` for each customer.
- Keep `maxWealth` outside the outer loop so it retains the highest total.
- Compare totals instead of replacing the maximum unconditionally.
