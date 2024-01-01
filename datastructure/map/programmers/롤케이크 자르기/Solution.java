// 1. key는 topping의 종류를, value에는 topping의 개수를 나타내는 Map 만들기

// 2. topping의 종류의 개수 세기
// 2.1 종류의 개수가 홀수 이면 0 반환

// 3. key는 topping의 종류를, value에는 topping의 개수를 나타내는 새로운 Map 만들기

// 4. topping을 처음부터 반복문을 돌며, 기존의 Map에서 topping을 제거하고, 새로운 Map에 넣기

// 5. 새로운 Map과 기존의 Mapdml topping의 종류의 개수가 같을 때, 정답 수 카운트 하기

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> toppingTypeToCount = computeToppingTypeToCount(topping);
        Map<Integer, Integer> newToppingTypeToCount = new HashMap<>();
        int toppingTypeCount = computeTypeCount(toppingTypeToCount);
        int newToppingTypeCount = 0;
        int answer = 0;
        for(int t : topping) {
            int toppingCount = toppingTypeToCount.get(t);
            if (toppingCount == 1) {
                toppingTypeCount--;
            }
            toppingTypeToCount.put(t, toppingCount - 1);
            toppingCount = newToppingTypeToCount.getOrDefault(t, 0);
            if (toppingCount == 0) {
                newToppingTypeCount++;
            }
            newToppingTypeToCount.put(t, toppingCount + 1);
            if (toppingTypeCount == newToppingTypeCount) {
                answer ++;
            }
            if (newToppingTypeCount > toppingTypeCount) {
                break;
            }
        }
        return answer;
    }

    private Map<Integer, Integer> computeToppingTypeToCount(int[] topping) {
        Map<Integer, Integer> toppingTypeToCount = new HashMap<>();
        for(int t : topping) {
            int toppingCount = toppingTypeToCount.getOrDefault(t, 0);
            toppingTypeToCount.put(t, toppingCount + 1);
        }
        return toppingTypeToCount;
    }

    private int computeTypeCount(Map<Integer, Integer> toppingTypeToCount) {
        return (int)toppingTypeToCount.values()
                .stream()
                .filter(v -> v != 0)
                .count();
    }
}