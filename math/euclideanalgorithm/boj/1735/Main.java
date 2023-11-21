import java.io.*;
import java.util.*;
class Main {
    private static int denominator, numerator;
    public static void main(String[] args) throws Exception{
        init();
        int gcd = findGcd(denominator, numerator);
        System.out.println(numerator / gcd + " " + denominator / gcd);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n3 = Integer.parseInt(st.nextToken());
        int n4 = Integer.parseInt(st.nextToken());
        denominator = n2 * n4;
        numerator = n1 * n4 + n2 * n3;
    }

    private static int findGcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return findGcd(n2, n1 % n2);
    }
}
