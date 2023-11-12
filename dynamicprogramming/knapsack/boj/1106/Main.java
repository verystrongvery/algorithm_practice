import java.io.*;
import java.util.*;
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int c, n;
    static int[][] input = new int[21][2];
    static long [][] memo = new long[21][1001];
    public static void main(String[] args) throws Exception {
        init();
        dp();
    }

    private static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= c; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private static void dp() {
        for(int i = 1; i <= n; i++) {
            int cost = input[i][0];
            int customerCount = input[i][1];
            for(int j = 1; j <= c; j++) {
                if (j - customerCount <= 0) {
                    memo[i][j] = Math.min(memo[i-1][j], cost);
                    continue;
                }
                memo[i][j] = Math.min(memo[i-1][j], memo[i][j - customerCount] + cost);
            }
        }
        System.out.println(memo[n][c]);
    }
}