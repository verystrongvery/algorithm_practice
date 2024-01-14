// 1. orders를 오름차순 정렬하기

// 2. orders의 조합을 이용하여 course에 해당하는 총 주문수와 총 주문수에 해당하는 문자열 구하기

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    List<String> answer = new ArrayList<>();
    Map<String, Integer> menuToCount = new HashMap<>();
    String[] bucket;
    int menuCountMax;
    boolean[] isVisited;

    public String[] solution(String[] orders, int[] course) {
        orders = Arrays.stream(orders)
                .map(this::sort)
                .toArray(String[]::new);
        for(int c : course) {
            solve(orders, c);
        }
        return answer.stream()
                .sorted()
                .toArray(String[]::new);
    }
    private String sort(String str) {
        return Arrays.stream(str.split(""))
                .sorted()
                .collect(Collectors.joining());
    }
    private void solve(String[] orders, int course) {
        menuToCount = new HashMap<>();
        menuCountMax = 0;
        for(String o : orders) {
            bucket = new String[course];
            isVisited = new boolean[o.length()];
            combination(o.split(""), course, 0);
        }
        if (menuCountMax < 2) {
            return ;
        }
        menuToCount.entrySet()
                .stream()
                .filter(es -> es.getValue() == menuCountMax)
                .forEach(es -> answer.add(es.getKey()));
    }

    private void combination(String[] order, int course, int depth) {
        if (depth == course) {
            String menu = Arrays.stream(bucket)
                    .collect(Collectors.joining());
            int menuCount = menuToCount.getOrDefault(menu, 0);
            menuToCount.put(menu, menuCount + 1);
            menuCountMax = Math.max(menuCountMax, menuCount + 1);
            return ;
        }
        for(int i = 0; i < order.length; i++) {
            if(isVisited[i] || (depth != 0 && (int)bucket[depth - 1].charAt(0) >= (int)order[i].charAt(0))) {
                continue;
            }
            isVisited[i] = true;
            bucket[depth] = order[i];
            combination(order, course, depth + 1);
            isVisited[i] = false;
        }
    }
}