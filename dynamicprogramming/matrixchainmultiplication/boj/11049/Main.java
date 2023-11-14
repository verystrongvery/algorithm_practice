import java.io.*;
import java.util.*;
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static long[][] matrixSize = new long[501][2];
    static long[][] memo = new long[501][501];

    public static void main(String[] args) throws Exception {
        init();
        dp();
        System.out.println(memo[1][n]);
    }

    private static void init() throws Exception {
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrixSize[i][0] = Long.parseLong(st.nextToken());
            matrixSize[i][1] = Long.parseLong(st.nextToken());
        }
    }

    private static void dp() {
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= n - i; j++) {
                long minValue = Long.MAX_VALUE;
                for (int k = 0; k < i; k++) {
                    minValue = Math.min(minValue, memo[j][j + k] + memo[j + k + 1][j + i] + matrixSize[j][0] * matrixSize[j + k][1] * matrixSize[j + i][1]);
                }
                memo[j][j + i] = minValue;
            }
        }
    }
}
