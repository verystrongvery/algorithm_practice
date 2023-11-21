import java.io.*;
import java.util.*;
class Main {
    static boolean[] isNotPrime = new boolean[1000001];
    static int m, n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        checkPrimeNumber();
        showPrimeNumber();
    }

    private static void checkPrimeNumber() {
        isNotPrime[1] = true;
        for(int i = 2; i * i <= n; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for(int j = 2; i * j <= n; j++) {
                isNotPrime[i * j] = true;
            }
        }
    }

    private static void showPrimeNumber() {
        for(int i = m; i <= n; i++) {
            if (!isNotPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
