// 1. 원소의 시작지점(src), 원소의 도착지점(dst) 변수 생성

// 2. src와 dst 사이의 합이 k보다 작으면,
// 2.1 dst가 마지막인 경우 종료
// 2.2 src와 dst + 1 사이의 합이 k보다 크거나 같으면, src 1 증가
// 2.4 src와 dst + 1 사이의 합이 k보다 작으면, dst 1 증가

// 3. src와 dst 사이의 합이 k와 같으면, 정답 확인하기 + src 1 증가

class Solution {
    public int[] solution(int[] sequence, int k) {
        int src = 0;
        int dst = 0;
        long sum = sequence[0];
        int[] answer = new int[2];
        answer[1] = sequence.length - 1;
        while (true) {
            if (sum < k) {
                if (dst == sequence.length - 1) {
                    break;
                }
                if (sum + sequence[dst + 1] > k) {
                    sum -= sequence[src++];
                }
                else {
                    sum += sequence[++dst];
                }
                continue;
            }
            if(answer[1] - answer[0] <= dst - src) {
                sum -= sequence[src++];
                continue;
            }
            answer[0] = src;
            answer[1] = dst;
            sum -= sequence[src++];
        }
        return answer;
    }
}