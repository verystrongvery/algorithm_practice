### Matrix Chain Multiplication
- 행렬들의 곱셈을 계산할때, 곱셈 연산횟수의 최소값을 구하는 문제
- 행렬 A(n1 X n2), 행렬 B(n2 X n3) 의 곱셈의 연산횟수: n1 * n2 * n3

### 문제 해결법
- memo[i][j]: i번째 행렬과 j번째 행렬까지 곱했을 때의 곱셈 연산횟수의 최소값
- memo[i][j] = min(memo[i][i+1] + memo[i+2][j] + 두 행렬의 곱셈 연산 횟수, memo[i][i+2] + memo[i+3][j] + 두 행렬의 곱셈 연산 횟수, ...)
