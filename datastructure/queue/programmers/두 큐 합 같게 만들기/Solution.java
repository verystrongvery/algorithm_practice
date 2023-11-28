import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Long> q1 = toQueue(queue1);
        Queue<Long> q2 = toQueue(queue2);
        int limit = q1.size() * 3;
        long sum1 = computeSum(q1);
        long sum2 = computeSum(q2);
        for (int i = 0; i <= limit; i++) {
            if (sum1 == sum2) {
                return answer;
            }
            answer++;
            if (sum1 > sum2) {
                long num = q1.poll();
                q2.offer(num);
                sum1 -= num;
                sum2 += num;
                continue;
            }
            long num = q2.poll();
            q1.offer(num);
            sum2 -= num;
            sum1 += num;
        }
        return -1;
    }

    private Queue<Long> toQueue(int[] intArr) {
        return Arrays.stream(intArr)
                .mapToLong(l -> (long)l)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private long computeSum(Queue<Long> q) {
        return q.stream()
                .mapToLong(l -> l)
                .sum();
    }
}
