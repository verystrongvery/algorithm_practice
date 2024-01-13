// 1. 연산횟수와 값을 가지는 클래스 Number 생성
// 1.1 연산횟수에 대해 오름차순이 되도록 Comparable 구현하기

// 2. Number 클래스가 원소인 우선순위 큐 생성
// 2.1 답을 구할때 까지 연산을 하면서 우선순위 큐에 Number 클래스 넣기

import java.util.PriorityQueue;

class Number implements Comparable<Number> {
    int operationCount;
    int value;

    public Number(int operationCount, int value) {
        this.operationCount = operationCount;
        this.value = value;
    }

    @Override
    public int compareTo(Number n) {
        return Integer.compare(operationCount, n.operationCount);
    }
}

class Solution {
    public int solution(int x, int y, int n) {
        PriorityQueue<Number> pq = new PriorityQueue<>();
        pq.offer(new Number(0, x));
        boolean[] visited = new boolean[1000001];
        int answer = -1;
        while(!pq.isEmpty()) {
            Number number = pq.poll();
            if (visited[number.value]) {
                continue;
            }
            visited[number.value] = true;
            if (number.value == y) {
                answer = number.operationCount;
                break;
            }
            if (number.value + n <= y) {
                pq.offer(new Number(number.operationCount + 1, number.value + n));
            }
            if (number.value * 2 <= y) {
                pq.offer(new Number(number.operationCount + 1, number.value * 2));
            }
            if (number.value * 3 <= y) {
                pq.offer(new Number(number.operationCount + 1, number.value * 3));
            }
        }
        return answer;
    }
}