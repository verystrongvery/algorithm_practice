class Solution {
    public long solution(int[] sequence) {
        long[] memo1 = new long[sequence.length];
        long[] memo2 = new long[sequence.length];
        memo1[0] = Math.max(sequence[0], 0);
        memo2[0] = Math.max(-sequence[0], 0);
        long answer = Math.max(memo1[0], memo2[0]);
        for(int i = 1; i < sequence.length; i++) {
            if (i % 2 == 0) {
                memo1[i] = Math.max(memo1[i - 1] + sequence[i], sequence[i]);
                memo2[i] = Math.max(memo2[i - 1] - sequence[i], - sequence[i]);
            } else {
                memo1[i] = Math.max(memo1[i - 1] - sequence[i], - sequence[i]);
                memo2[i] = Math.max(memo2[i - 1] + sequence[i], sequence[i]);
            }
            answer = Math.max(answer, Math.max(memo1[i], memo2[i]));
        }
        return answer;
    }
}
