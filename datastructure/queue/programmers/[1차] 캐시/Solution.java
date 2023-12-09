import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        for(String city : cities) {
            city = city.toLowerCase();
            if (q.size() > cacheSize) {
                q.poll();
            }
            if (q.contains(city)) {
                answer += 1;
                q.remove(city);
                q.offer(city);
                continue;
            }
            q.add(city);
            answer += 5;
        }
        return answer;
    }
}
