class Solution {
    public int solution(int n, int[] money) {
        int[][] dp = new int[money.length][n + 1];
        for(int i = 1; i <= n; i++) {
            if (i % money[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for(int i = 1; i < money.length; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][0] = 1;
                dp[i][j] = dp[i - 1][j];
                if (j >= money[i]) {
                    dp[i][j] += dp[i][j - money[i]];
                }
            }
        }
        return dp[money.length - 1][n];
    }
}
