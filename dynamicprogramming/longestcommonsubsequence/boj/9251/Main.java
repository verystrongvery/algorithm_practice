import java.io.*;
import java.util.*;
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str1;
    static String str2;
    static long memo[][] = new long[1001][1001];
    public static void main(String[] args) throws Exception {
        init();
        dp();
        System.out.println(memo[str1.length()][str2.length()]);
    }

    private static void init() throws Exception {
        str1 = br.readLine();
        str2 = br.readLine();
    }

    private static void dp() {
        for(int i = 1; i <= str1.length(); i++) {
            for(int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    memo[i][j] = memo[i-1][j-1] + 1;
                    continue;
                }
                memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
            }
        }
    }
}
