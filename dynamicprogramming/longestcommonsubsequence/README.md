### Longest Common Subsequence
- 문자열 A와 문자열 B에서, 공통 부분 문자열이 여러개 존재
- 여러 공통 부분 문자열들 중 가장 길이가 긴 문자열의 길이를 구하는 문제
- 공통 부분 문자열은 연속되지 않아도 됨

### 문제 해결법
- memo[i][j]: A의 i번째 문자와 B의 j번째 문자까지 비교했을때의 LCS
- A의 i번째 문자와 B의 j번째 문자가 같다면, memo[i][j] = memo[i-1][j-1] + 1
- A의 i번째 문자와 B의 j번째 문자가 다르다면, memo[i][j] = Max(memo[i-1][j], memo[i-1][j])