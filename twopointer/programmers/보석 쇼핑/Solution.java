import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] gems) {
        int gemTypeCount = (int)Arrays.stream(gems)
                .collect(Collectors.toSet())
                .size();
        Map<String, Integer> bucket = new HashMap<>();
        int src = 0;
        int dst = -1;
        int gemsRangeMin = 987654321;
        int srcAnswer = 0;
        int dstAnswer = 0;
        while(++dst < gems.length) {
            int gemCount = bucket.getOrDefault(gems[dst], 0);
            bucket.put(gems[dst], gemCount + 1);
            if (gemTypeCount != computeMapSize(bucket)) {
                continue;
            }
            while(true) {
                if (isGemCountOne(bucket, gems[src])) {
                    break;
                }
                src++;
            }
            if (dst - src < gemsRangeMin) {
                gemsRangeMin = dst - src;
                srcAnswer = src + 1;
                dstAnswer = dst + 1;
            }
        }
        return new int[]{srcAnswer, dstAnswer};
    }

    private int computeMapSize(Map<String, Integer> map) {
        return (int)map.keySet()
                .stream()
                .count();
    }

    private boolean isGemCountOne(Map<String, Integer> bucket, String gem) {
        int gemCount = bucket.get(gem);
        if (gemCount == 1) {
            return true;
        }
        bucket.put(gem, gemCount - 1);
        return false;
    }
}
