import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int min = Arrays.stream(s.split(" "))
                .mapToInt(n -> Integer.parseInt(n))
                .min()
                .getAsInt();
        int max = Arrays.stream(s.split(" "))
                .mapToInt(n -> Integer.parseInt(n))
                .max()
                .getAsInt();
        String answer = min + " " + max;
        return answer;
    }
}
