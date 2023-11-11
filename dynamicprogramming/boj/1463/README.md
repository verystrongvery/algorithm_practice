### 문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

- X가 3으로 나누어 떨어지면, 3으로 나눈다.
- X가 2로 나누어 떨어지면, 2로 나눈다.
- 1을 뺀다.

정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 
연산을 사용하는 횟수의 최솟값을 출력하시오.

### 시간제한, 입력값
- 시간제한: 0.15초
- 입력값: 1 <= N <= 1000000

### Top Down 방식 문제 설계
1. N이 1000000 이라 가정
2. 크기가 1000001인 momoization 배열을 만들고, momoization[1] = 0, momoization[2] = 1, momoization[3] = 1 저장
3. momoization[i] = min(momoization[i/3], momoization[i/2], momoization[i-1]) + 1 점화식 이용하여 재귀함수 호출
4. momoization[1000000] = min(momoization[1000000/3], momoization[500000], momoization[999999]) + 1
5. 4번의 결과를 재귀 호출로 반복하여 최종해 구하기
6. 시간복잡도는 O(N), 입력값은 최대 1000000 이므로, 1000000 < 100000000 * 0.15 이므로 1초 안에 해결 가능
7. 하지만 재귀 호출 깊이가 너무 깊어 스택오버플로우가 생길 가능성이 있음

### Bottiom Up 방식 문제 설계
1. N이 1000000 이라 가정
2. 크기가 1000001인 momoization 배열을 만들고, momoization[1] = 0, momoization[2] = 1, momoization[3] = 1 저장
3. momoization[i] = min(momoization[i/3], momoization[i/2], momoization[i-1]) + 1 점화식 이용하여 반복문 호출
4. momoization[4] = min(momoization[4/3], momoization[2], momoization[3]) + 1
5. 4번의 결과를 반복문으로 반복하여 최종해 구하기
6. 시간복잡도는 O(N), 입력값은 최대 1000000 이므로, 1000000 < 100000000 * 0.15 이므로 1초 안에 해결 가능