class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= t * m; i ++) {
            sb.append(Integer.toString(i, n));
        }
        String totalStr = sb.toString().toUpperCase();
        sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            sb.append(totalStr.charAt(i * m + p - 1));
        }
        return sb.toString();
    }
}
