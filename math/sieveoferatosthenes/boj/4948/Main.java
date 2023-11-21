import java.io.*;
import java.util.*;
class Main {
    private static final int N_MAX = 123456;
    private static boolean[] isNotPrime = new boolean[N_MAX * 2 + 1];
    private static int[] primeCount = new int[N_MAX * 2 + 1];
    private static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws Exception {
        findPrimeNumber();
        computePrimeCount();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            sb.append(primeCount[n * 2] - primeCount[n] + "\n");
        }
        System.out.println(sb);
    }

    private static void findPrimeNumber() {
        isNotPrime[1] = true;
        for(int i = 2; i * i <= N_MAX * 2; i++) {
            for(int j = 2; i * j <= N_MAX * 2; j++) {
                isNotPrime[i * j] = true;
            }
        }
    }

    private static void computePrimeCount() {
        int count = 0;
        for(int i = 2; i <= N_MAX * 2; i++) {
            if (!isNotPrime[i]) {
                ++count;
            }
            primeCount[i] = count;
        }
    }
}
