import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        String str = Arrays.stream(s.split(" "))
                .map(this::toJadenCase)
                .collect(Collectors.joining(" "));
        while (str.length() != s.length()) {
            str += " ";
        }
        return str;
    }

    private String toJadenCase(String str) {
        if (str.length() <= 1) {
            return str.toUpperCase();
        }
        return (Character.toUpperCase(str.charAt(0))) + str.substring(1).toLowerCase();
    }
}
