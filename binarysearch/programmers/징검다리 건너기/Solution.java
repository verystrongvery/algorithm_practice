import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;
        while(left < right) {
            int mid = (left + right) / 2;
            if (isPossible(mid, stones, k)) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }
        return left - 1;
    }

    private boolean isPossible(int mid, int[] stones, int k) {
        int count = 0;
        for(int stone : stones) {
            if (mid <= stone) {
                count = 0;
                continue;
            }
            if (++count == k) {
                return false;
            }
        }
        return true;
    }
}
