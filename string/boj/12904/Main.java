import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        boolean isSolve = solve(s, t);
        int result = isSolve == true ? 1 : 0;
        System.out.println(result);
    }


    private static boolean solve(String s, String t) {
        while(s.length() != t.length()) {
            char lastCharactr = t.charAt(t.length() - 1);
            t = t.substring(0, t.length() - 1);
            if (lastCharactr == 'B') {
                t = reverseString(t);
            }
        }
        return s.equals(t);
    }

    private static String reverseString(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }
}
