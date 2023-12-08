import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        int i;
        for(i = 1; i < words.length; i++) {
            if(words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                break ;
            }
            if (map.getOrDefault(words[i], 0) == 1) {
                break ;
            }
            map.put(words[i], 1);
        }
        if (i == words.length) {
            return new int[] {0, 0};
        }
        int answer1 = (i + 1) % n == 0 ? n : (i + 1) % n;
        int answer2 = (i + 1) % n == 0 ? (i + 1) / n : (i + 1) / n + 1;
        return new int[] {answer1, answer2};
    }
}
