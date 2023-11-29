class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int elementMin = s / n;
        int elementMaxCount =  s - (s / n) * n;
        for(int i = 0; i < n; i++) {
            answer[i] = elementMin;
            if (n - i <= elementMaxCount) {
                answer[i]++;
            }
        }
        return answer;
    }
}
