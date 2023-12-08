class Solution {
    public int solution(int n) {
        int n1 = 1;
        int n2 = 1;
        int temp;
        for(int i = 2; i < n; i++) {
            temp = n2;
            n2 += n1;
            n1 = temp;
            n1 %= 1234567;
            n2 %= 1234567;
        }
        return n2;
    }
}
