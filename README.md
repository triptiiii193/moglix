# Longest Valid Parentheses

Given a string containing just the characters `'('` and `')'`, return the length
of the longest valid (well-formed) parentheses substring.

## Examples

| Input        | Output | Explanation                          |
|--------------|--------|---------------------------------------|
| `"(()"`      | 2      | Longest valid substring is `"()"`     |
| `")()())"`   | 4      | Longest valid substring is `"()()"`   |
| `""`         | 0      | Empty string has no valid substring   |

## Constraints

- `0 <= s.length <= 3 * 10^4`
- `s[i]` is `'('` or `')'`

## Approach

### 1. Two-pass counter scan (used as the primary solution)

- **Left-to-right pass:** Track counts of `(` and `)`. Whenever the counts
  are equal, we've found a valid substring of length `2 * count`. If `)`
  count ever exceeds `(` count, that segment is broken beyond repair, so
  reset both counters.
- **Right-to-left pass:** Same idea, mirrored. This is required to catch
  cases like `"(()"`, where a surplus of unmatched `(` on the left side
  hides a valid substring that the first pass alone would miss.

**Complexity:** O(n) time, O(1) space.

### 2. Stack-based approach (alternative, included for comparison)

- Push `-1` onto the stack as a sentinel base index.
- For each `(`, push its index.
- For each `)`, pop the stack:
  - If the stack becomes empty, push the current index as the new base.
  - Otherwise, the valid length is `current index - stack top`.

**Complexity:** O(n) time, O(n) space.

## Running

```bash
javac LongestValidParentheses.java
java LongestValidParentheses
```

This runs a small built-in test suite and prints PASS/FAIL for each case.

## Files

- `LongestValidParentheses.java` — solution with both approaches and tests# moglix