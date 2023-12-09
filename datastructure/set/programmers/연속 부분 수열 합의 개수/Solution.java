import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= elements.length; i++) {
            for(int j = 0; j < elements.length; j++) {
                int sum = computeSubSum(elements, j, i);
                set.add(sum);
            }
        }
        return set.size();
    }

    private int computeSubSum(int[] elements, int src, int size) {
        int result = 0;
        for(int i = src; i < src + size; i++) {
            if (i > elements.length - 1) {
                result += elements[i - elements.length];
                continue;
            }
            result += elements[i];
        }
        return result;
    }
}
