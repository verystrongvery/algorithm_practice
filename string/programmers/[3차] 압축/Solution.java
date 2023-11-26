import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        List<String> dictionary = init();
        List<Integer> answer = new ArrayList();
        while(msg.length() != 0) {
            msg = compression(msg, dictionary, answer);
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private List<String> init() {
        return IntStream.range(0, 26)
                .mapToObj(i -> String.valueOf((char)('A' + i)))
                .collect(Collectors.toList());
    }

    private String compression(String msg, List<String> dictionary, List<Integer> answer) {
        String msgSubStr = "";
        for(int i = 1; i <= msg.length(); i++) {
            msgSubStr = msg.substring(0, i);
            if (!dictionary.contains(msgSubStr)) {
                dictionary.add(msgSubStr);
                answer.add(dictionary.indexOf(msg.substring(0, i - 1)) + 1);
                return msg.substring(i - 1, msg.length());
            }
        }
        answer.add(dictionary.indexOf(msgSubStr) + 1);
        return "";
    }
}
