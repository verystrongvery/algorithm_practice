### Longest Increasing Subsequence
- 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열의 크기를 구하는 문제

### 문제 해결법
- memo[i]: 수열 A의 i번째 수 까지의 LIS
- i번째 수가 j번째 수보다 크다면, memo[i] = max(memo[i], memo[j] + 1)
- i번째 수가 j번째 수보다 작다면, memo[i]는 변하지 않음
