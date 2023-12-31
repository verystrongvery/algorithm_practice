### String 메소드
- String.charAt(i): 문자열의 인덱스 i에 해당하는 문자 조회
- String.substring(a, b): 문자열의 자르기(인덱스 a ~ b-1)
- StringBuffer.reverse().toString(): 문자열 뒤집기
- String.toLoserCase(): 소문자로 변경
- String.toCharArray(): String을 char 배열로 변환
- String.split(s): 문자열 s를 기준으로 문자열을 나누어 배열에 저장하여 반환
- String.replaceAll(정규표현식, s): 정규표현식에 해당하는 부분을 s로 변경
- String.matches(정규표현식): 문자열이 정규표현식에 일치하면 true 반환
- String.indexOf(s): 조회하려는 문자열이 처음 발견되는 위치 반환
- String.chars():  String의 문자들을 IntStream으로 만듬
- String.trim(): 문자열 양끝의 공백 제거

### Character 메소드
- Character.isDigit(): char 문자가 숫자인지 조회
- Character.getNumericValue(): char 문자를 숫자로 변환
- Character.toLowerCase(): 소문자로 변경

### Integer 메소드
- Integer.toBinaryString(i): 정수 i를 이진수 형식의 문자열로 반환
- Integer.parseInt(s, n): n진수 형태의 s 문자열을 10진수 숫자로 변환

### Collectors 메소드
- Collectors.joining(str): 문자열 스트림을 str을 붙여서 join

### 정규표현식
- [abc] : a, b, c 중 한 문자
- ^[a-zA-Z]*$: 문자열이 전부 알파벳으로 이루어져 있음

### Stream 메소드
- toArray(String[]::new): 스트림을 String 배열로 변환
