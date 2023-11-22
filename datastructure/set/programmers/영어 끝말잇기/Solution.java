import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> dictionary = new HashSet<>();
        int order = 0;
        while (++order < words.length) {
            dictionary.add(words[order - 1]);
            if (words[order - 1].charAt(words[order - 1].length() - 1) != words[order].charAt(0) || dictionary.contains(words[order])) {
                break;
            }
        }
        if (order == words.length) {
            return new int[]{0, 0};
        }
        return new int[]{(order) % n + 1, (order) / n + 1};
    }
}
