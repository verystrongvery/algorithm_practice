import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int bIndex = B.length - 1;
        int answer = 0;
        for(int i = A.length - 1; i >= 0; i--) {
            if (bIndex < 0 || B[bIndex] <= A[i]) {
                continue ;
            }
            bIndex--;
            answer++;
        }
        return answer;
    }
}
