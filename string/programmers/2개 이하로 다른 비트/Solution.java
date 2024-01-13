// 1. 10진수를 2진수로 변환
// 2. 2진수의 작은 비트부터 처음으로 0이 나오는 자리수 찾기
// 3. 처음으로 0이 나오는 자리수를 1로 바꾸기
// 4. 처음으로 0이 나오는 자리수 전의 자리가 존재하면 0으로 바꾸기

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public long[] solution(long[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .map(Long::toBinaryString)
                .map(this::convert)
                .mapToLong(str -> Long.valueOf(str, 2))
                .toArray();
    }

    private String convert(String number) {
        int index = number.lastIndexOf('0');
        if (index == number.length() - 1) {
            return number.substring(0, number.length() - 1) + "1";
        }
        if (index == -1) {
            return "10" + number.substring(1);
        }
        return number.substring(0, index) + "10" + number.substring(index + 2);
    }
}