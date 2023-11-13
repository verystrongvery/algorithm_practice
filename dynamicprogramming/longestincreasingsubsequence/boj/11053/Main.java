import java.io.*;
import java.util.*;
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long[] memo = new long[1000];
    static long[] sequence = new long[1000];
    static long n;
    public static void main(String[] args) throws Exception{
        init();
        long output = dp();
        System.out.println(output);
    }

    private static void init() throws Exception{
        n = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            sequence[i] = Long.parseLong(st.nextToken());
        }
    }

    private static long dp() {
        long output = 1;
        for(int i = 0; i < n; i++) {
            memo[i] = 1;
            for(int j = 0; j < i; j++) {
                if (sequence[i] <= sequence[j]) {
                    continue;
                }
                memo[i] = Math.max(memo[i], memo[j] + 1);
                output = Math.max(output, memo[i]);
            }
        }
        return output;
    }
}
