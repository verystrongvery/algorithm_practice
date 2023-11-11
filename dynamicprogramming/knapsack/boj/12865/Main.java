import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {

    private static final int N_MAX = 100;
    private static final int K_MAX = 100000;
    private static final int input[][] = new int[N_MAX + 1][2];
    private static final long memo[][] = new long[N_MAX + 1][K_MAX + 1];
    private static int n;
    private static int k;
    public static void main(String[] args) throws Exception {
        init();
        long output = dp();
        System.out.println(output);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            input[i][0] = w;
            input[i][1] = v;
        }
    }

    private static long dp() {
        long output = 0;
        for(int i = 1; i <= n; i++) {
            int w = input[i][0];
            int v = input[i][1];
            for(int j = 1; j <= k; j++) {
                if (j - w < 0) {
                    memo[i][j] = memo[i - 1][j];
                    continue;
                }
                memo[i][j] = Math.max(memo[i - 1][j], memo[i - 1][j - w] + v);
            }
        }
        return memo[n][k];
    }
}