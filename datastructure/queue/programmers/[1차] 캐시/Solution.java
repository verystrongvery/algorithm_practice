import java.util.*;

class Solution {
    Queue<String> q = new LinkedList<>();
    int answer = 0;

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        for(String city : cities) {
            chooseUseCache(city.toLowerCase(), cacheSize);
        }
        return answer;
    }

    private void chooseUseCache(String city, int cacheSize) {
        if (q.contains(city)) {
            useCache(city);
            return ;
        }
        if(q.size() == cacheSize){
            q.poll();
        }
        q.offer(city);
        answer += 5;
    }

    private void useCache(String cachedCity) {
        Queue<String> newQ = new LinkedList<>();
        while(!q.isEmpty()) {
            String city = q.poll();
            if (city.equals(cachedCity)) {
                continue;
            }
            newQ.offer(city);
        }
        newQ.offer(cachedCity);
        q = newQ;
        answer++;
    }
}
