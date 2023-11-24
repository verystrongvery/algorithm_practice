import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {
        Map map1 = createStringMap(str1.toLowerCase());
        Map map2 = createStringMap(str2.toLowerCase());
        int map1Size = computeMapSize(map1);
        int map2Size = computeMapSize(map2);
        Map cobinedMap = combineMap(map1, map2);
        int cobinedMapSize = computeMapSize(cobinedMap);
        double answer = ((double) map1Size + map2Size - cobinedMapSize) / cobinedMapSize * 65536 ;
        if (cobinedMapSize == 0) {
            return 65536;
        }
        return (int) answer;
    }

    private Map<String, Integer> createStringMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 1; i < s.length(); i++) {
            String subString = s.substring(i - 1, i + 1);
            if (!isAlpha(subString)) {
                continue;
            }
            int mapValue = map.getOrDefault(subString, 0);
            map.put(subString, mapValue + 1);
        }
        return map;
    }

    private int computeMapSize(Map<String, Integer> map) {
        return map.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private Map combineMap(Map<String, Integer> map1, Map<String, Integer> map2) {
        map2.entrySet()
                .stream()
                .forEach(es -> combineMap(map1, es.getKey(), es.getValue()));
        return map1;
    }

    private void combineMap(Map<String, Integer> map, String key, int value) {
        if(!map.containsKey(key)) {
            map.put(key, value);
            return ;
        }
        int value2 = map.getOrDefault(key, 0);
        map.put(key, Math.max(value, value2));
    }

    private boolean isAlpha(String s) {
        return s.matches("^[a-z]*$");
    }
}
