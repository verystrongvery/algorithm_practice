import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    Map<Integer, Integer> courseMaxCount = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        for(String order : orders) {
            order = sort(order);
            computeCombination(order, 0, "");
        }
        List<Integer> courseList = Arrays.stream(course)
                .boxed()
                .collect(Collectors.toList());
        return map.entrySet()
                .stream()
                .filter(es -> es.getValue() >= 2 && courseList.contains(es.getKey().length()) && courseMaxCount.get(es.getKey().length()) == es.getValue())
                .map(es -> es.getKey())
                .sorted()
                .toArray(String[]::new);
    }

    private String sort(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private void computeCombination(String order, int index, String combination) {
        if (index == order.length()) {
            if (combination.length() >= 2) {
                int count = map.getOrDefault(combination, 0);
                map.put(combination, count + 1);
                int courseCount = courseMaxCount.getOrDefault(combination.length(), 0);
                courseCount = Math.max(courseCount, count + 1);
                courseMaxCount.put(combination.length(), courseCount);
            }
            return ;
        }
        computeCombination(order, index + 1, combination);
        computeCombination(order, index + 1, combination + order.charAt(index));
    }
}
