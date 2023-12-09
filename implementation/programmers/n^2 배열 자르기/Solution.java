import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Long> list = new ArrayList<>();
        for(long i = left; i <= right; i++) {
            long n1 = i / n + 1;
            long n2 = (i + 1) % n == 0 ? n : (i + 1) % n;
            list.add(Math.max(n1, n2));
        }
        return list.stream()
                .mapToInt(i -> (int)i.longValue())
                .toArray();
    }
}
