import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String msg) {
        List<String> dictionary = initDictionary();
        List<String> answer = solve(dictionary, msg);
        return answer.stream()
                .mapToInt(str -> dictionary.indexOf(str) + 1)
                .toArray();
    }

    private List<String> initDictionary() {
        return IntStream.range(0, 26)
                .mapToObj(i -> String.valueOf((char)('A' + i)))
                .collect(Collectors.toList());
    }

    private List<String> solve(List<String> dictionary, String msg) {
        List<String> answer = new ArrayList<>();
        int i = 0;
        while (i < msg.length()) {
            int j = i + 1;
            while (j <= msg.length()) {
                String subStr = msg.substring(i, j);
                if (j == msg.length() && dictionary.contains(subStr)) {
                    answer.add(subStr);
                    j = msg.length() + 1;
                    break ;
                }
                else if (dictionary.contains(subStr)) {
                    j++;
                    continue;
                }
                dictionary.add(subStr);
                answer.add(subStr.substring(0, subStr.length() - 1));
                break ;
            }
            i = j - 1;
        }
        return answer;
    }
}
