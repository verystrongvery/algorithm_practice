### 문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

### 입력값
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

### 출력값
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

### 예제 입력
4 2

### 예제 출력
1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3

### 시간제한
1초

### 문제 설게
1. 백트래킹을 활용하여 중복되는 수열을 여러번 출력하지 않고, 완전 탐색
2. 시간복잡도는 8^8 < 10^7 이므로 1초안에 해결 가능 
