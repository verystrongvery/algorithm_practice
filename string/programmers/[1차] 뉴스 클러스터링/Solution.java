import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> str1Map = computeStrMap(str1);
        Map<String, Integer> str2Map = computeStrMap(str2);
        Map<String, Integer> complementMap = computeComplementMap(str1Map, str2Map);
        Map<String, Integer> unionMap = computeUnionMap(str1Map, str2Map);
        int complementCount = computeMapSum(complementMap);
        int unionCount = computeMapSum(unionMap);
        if (unionCount == 0) {
            return 65536;
        }
        return complementCount * 65536 / unionCount;
    }

    private Map<String, Integer> computeStrMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 1; i < str.length(); i++) {
            String substr = str.substring(i - 1, i + 1).toLowerCase();
            if (!substr.matches("^[a-z]*$")) {
                continue;
            }
            int count = map.getOrDefault(substr, 0);
            map.put(substr, count + 1);
        }
        return map;
    }

    private Map<String, Integer> computeComplementMap(Map<String, Integer> str1Map, Map<String, Integer> str2Map) {
        return str1Map.entrySet()
                .stream()
                .filter(es -> str2Map.containsKey(es.getKey()))
                .collect(Collectors.toMap(es -> es.getKey(), es -> Math.min(es.getValue(), str2Map.get(es.getKey()))));
    }

    private Map<String, Integer> computeUnionMap(Map<String, Integer> str1Map, Map<String, Integer> str2Map) {
        Map<String, Integer> map = new HashMap<>();
        map.putAll(str1Map);
        str2Map.entrySet()
                .stream()
                .forEach(es -> map.put(es.getKey(), Math.max(es.getValue(), str1Map.getOrDefault(es.getKey(), 0))));
        return map;
    }

    private int computeMapSum(Map<String, Integer> map) {
        return map.values()
                .stream()
                .mapToInt(i -> i)
                .sum();
    }
}
