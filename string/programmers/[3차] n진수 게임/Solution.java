import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public String solution(int n, int t, int m, int p) {
        List<String> answer = new ArrayList<>();
        int order = 0;
        for(int i = 0;;i++) {
            List<String> strList = Integer.toString(i, n)
                    .chars()
                    .mapToObj(c -> String.valueOf((char)c).toUpperCase())
                    .collect(Collectors.toList());
            for(String str : strList) {
                order++;
                if ((m == p && order % m == 0) || (order % m == p)) {
                    answer.add(str);
                }
            }
            if (answer.size() >= t) {
                break;
            }
        }
        return answer.stream()
                .collect(Collectors.joining())
                .substring(0, t);
    }
}
