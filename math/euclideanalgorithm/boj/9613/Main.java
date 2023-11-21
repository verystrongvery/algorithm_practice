import java.io.*;
import java.util.*;
class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            long gcdSum = findGcdSum();
            sb.append(gcdSum + "\n");
        }
        System.out.println(sb);
    }

    private static long findGcdSum() throws Exception {
        long gcdSum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                gcdSum += findGcd(numbers[i], numbers[j]);
            }
        }
        return gcdSum;
    }

    private static int findGcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return findGcd(n2, n1 % n2);
    }
}
