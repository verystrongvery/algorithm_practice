import java.io.*;
import java.util.*;
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            solve();
        }
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int coin[] = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        long memo[][] = new long[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            memo[i][0] = 1;
            for(int j = 1; j <= m; j++) {
                memo[i][j] = j - coin[i] < 0 ? memo[i-1][j] : memo[i-1][j] + memo[i][j - coin[i]];
            }
        }
        System.out.println(memo[n][m]);
    }
}