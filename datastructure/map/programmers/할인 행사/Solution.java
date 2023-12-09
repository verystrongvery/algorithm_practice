import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i = 0; i <= discount.length - 10; i++) {
            if (isAnswer(want, number, discount, i)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isAnswer(String[] want, int[] number, String[] discount, int src) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < 10; i++) {
            int value = map.getOrDefault(discount[src + i], 0);
            map.put(discount[src + i], value + 1);
        }
        for(int i = 0; i < want.length; i++) {
            int value = map.getOrDefault(want[i], 0);
            if (value < number[i]) {
                return false;
            }
        }
        return true;
    }
}
