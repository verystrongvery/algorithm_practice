// 1. 큐의 합이 큰쪽에서 원소를 빼고, 큐의 합이 작은쪽으로 원소 넣기
// 2. 두 큐의 크기의 합만큼 원소를 빼고 넣었는데 답을 구하지 못했다면 -1 반환

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        Queue<Integer> q1 = initQueue(queue1);
        Queue<Integer> q2 = initQueue(queue2);
        int answer = 0;
        for(int i = 0; i < (queue1.length + queue2.length) * 2; i++) {
            if (sum1 == sum2) {
                return answer;
            }
            answer++;
            if (sum1 > sum2) {
                int element = q1.poll();
                q2.offer(element);
                sum1 -= element;
                sum2 += element;
                continue;
            }
            int element = q2.poll();
            q1.offer(element);
            sum2 -= element;
            sum1 += element;
        }
        return -1;
    }

    private Queue<Integer> initQueue(int[] queue) {
        Queue<Integer> q = new LinkedList<>();
        for(int element : queue) {
            q.offer(element);
        }
        return q;
    }
}