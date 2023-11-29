import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Queue;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> pq = Arrays.stream(works)
                .map(work -> -work)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
        for(int i = 0; i < n; i++) {
            int work = pq.poll();
            if (work == 0) {
                break ;
            }
            pq.offer(work + 1);
        }
        return pq.stream()
                .mapToLong(work -> work * work)
                .sum();
    }
}
