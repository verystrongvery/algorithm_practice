class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        for(long i = left; i <= right; i++) {
            long quotient = i / n ;
            long remainder = i % n;
            answer[(int)(i - left)] = Math.max((int)quotient, (int)remainder) + 1;
        }
        return answer;
    }
}
