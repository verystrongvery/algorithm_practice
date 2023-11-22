### 문제
두 문자열이 주어졌을 때, 두 문자열에 모두 포함된 가장 긴 공통 부분 문자열을 찾는 프로그램을 작성하시오.

어떤 문자열 s의 부분 문자열 t란, s에 t가 연속으로 나타나는 것을 말한다.
예를 들어, 문자열 ABRACADABRA의 부분 문자열은 ABRA, RAC, D, ACADABRA, ABRACADABRA, 빈 문자열 등이다. 하지만, ABRC, RAA, BA, K는 부분 문자열이 아니다.

두 문자열 ABRACADABRA와 ECADADABRBCRDARA의 공통 부분 문자열은 CA, CADA, ADABR, 빈 문자열 등이 있다.
이 중에서 가장 긴 공통 부분 문자열은 ADABR이며, 길이는 5이다. 또,
두 문자열이 UPWJCIRUCAXIIRGL와 SBQNYBSBZDFNEV인 경우에는 가장 긴 공통 부분 문자열은 빈 문자열이다.

### 입력값
첫째 줄과 둘째 줄에 문자열이 주어진다. 문자열은 대문자로 구성되어 있으며, 길이는 1 이상 4000 이하이다.

### 출력값
첫째 줄에 두 문자열에 모두 포함 된 부분 문자열 중 가장 긴 것의 길이를 출력한다.

### 예제 입력 1
ABRACADABRA
ECADADABRBCRDARA

### 예제 출력 1
5

### 시간제한
2초

### 문제 설게
- s[i] == t[j] 이면, memo[i][j] = memo[i - 1][j - 1] + 1
- s[i] != t[j] 이면, memo[i][j] = 0
- 시간복잡도는 4000 * 4000 < 2 * 10^8 이므로 2초안에 해결 가능
