import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {
    private static final int N_MAX = 100;
    private static final int C_MAX = 100;
    private static final long[][] memo = new long[N_MAX + 1][N_MAX * C_MAX + 1];
    private static int[] a = new int[N_MAX + 1];
    private static int[] c = new int[N_MAX + 1];
    private static int N, M;

    public static void main(String[] args) throws Exception{
        init();
        dp();
        int output = solve();
        System.out.println(output);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void dp() {
        for(int i = 1; i <= N; i++) {
            if (c[i] == 0) {
                memo[i][0] = memo[i - 1][0] + a[i];
            }
            for(int j = 1; j <= N * C_MAX; j++) {
                if (j - c[i] < 0) {
                    memo[i][j] = memo[i - 1][j];
                    continue ;
                }
                memo[i][j] = Math.max(memo[i - 1][j], memo[i - 1][j - c[i]] + a[i]);
            }
        }
    }

    private static int solve() {
        for(int i = 1; i <= N * C_MAX; i++) {
            if (memo[N][i] >= M) {
                return i;
            }
        }
        return 0;
    }
}