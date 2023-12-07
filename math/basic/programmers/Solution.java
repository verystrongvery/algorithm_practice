class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n / 2; i++) {
            if (isAnswer(i, n)) {
                answer++;
            }
        }
        return answer + 1;
    }

    private boolean isAnswer(int idx, int n) {
        int sum = 0;
        while (sum < n) {
            sum += idx++;
        }
        return sum == n;
    }
}
