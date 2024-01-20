// 1. orders 알파벳 순서에 맞게 정렬하기

// 2. course를 반복문으로 돌리기

// 3. course에 대한 orders의 조합 결과를 카운팅한 해시 맵 만들기

// 4. 해시 맵의 가장 큰 값은 가진 조합 결과를 result 배열에 추가하기

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    List<String> result = new ArrayList<>();
    Map<String, Integer> menuToMenuCount;
    boolean[] isVisit;
    public String[] solution(String[] orders, int[] course) {
        orders = Arrays.stream(orders)
                .map(this::sort)
                .toArray(String[]::new);
        for(int c : course) {
            findResult(orders, c);
        }
        return result.stream()
                .sorted()
                .toArray(String[]::new);
    }

    private String sort(String str) {
        return Arrays.stream(str.split(""))
                .sorted()
                .collect(Collectors.joining());
    }

    private void findResult(String[] orders, int course) {
        menuToMenuCount = new HashMap<>();
        for(String o : orders) {
            isVisit = new boolean[o.length()];
            combination(o, course, "");
        }
        int maxMenuCount = menuToMenuCount.values()
                .stream()
                .mapToInt(v -> v)
                .max()
                .orElse(0);
        menuToMenuCount.entrySet()
                .stream()
                .filter(es -> es.getValue() == maxMenuCount && es.getValue() >= 2)
                .forEach(es -> result.add(es.getKey()));
    }

    private void combination(String order, int course, String element) {
        if (element.length() == course) {
            int menuToCount = menuToMenuCount.getOrDefault(element, 0);
            menuToMenuCount.put(element, menuToCount + 1);
            return ;
        }
        for(int i = 0; i < order.length(); i++) {
            if (isVisit[i] || (element.length() > 0 && (int)order.charAt(i) <= (int)element.charAt(element.length() - 1))) {
                continue;
            }
            isVisit[i] = true;
            combination(order, course, element + order.charAt(i));
            isVisit[i] = false;
        }
    }
}