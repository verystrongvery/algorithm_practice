import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int answer = dp(s, t);
        System.out.println(answer);
    }

    public static int dp(String s, String t) {
        int memo[][] = new int[4001][4001];
        int answer = 0;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                    answer = Math.max(answer, memo[i][j]);
                }
            }
        }
        return answer;
    }
}
