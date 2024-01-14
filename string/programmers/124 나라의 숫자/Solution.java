// 1. 10진수를 3진수로 변경

// 2. 3진수의 맨 끝부터 반복문 돌리기
// 2.1 해당 자리가 0 이하면, 3 더하고, 앞에 자리 -1 빼기

// 3. 3진수의 3을 4로 변경

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(int n) {
        int[] arr = Arrays.stream(Integer.toString(n, 3).split(""))
                .mapToInt(str -> Integer.parseInt(str))
                .toArray();
        for(int i = arr.length - 1; i > 0; i--) {
            if (arr[i] <= 0) {
                arr[i] += 3;
                arr[i - 1]--;
            }
        }
        String answer = Arrays.stream(arr)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining());
        if (answer.charAt(0) == '0') {
            answer = answer.substring(1);
        }
        return answer.replaceAll("3", "4");
    }
}