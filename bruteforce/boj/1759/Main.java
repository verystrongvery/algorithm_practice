import java.io.*;
import java.util.*;

class Main {
    private static int l, c;
    private static char[] input;
    private static char[] bucket;
    private static boolean[] isVisit;
    private static StringBuilder sb = new StringBuilder();
    private static char[] vowel = new char[] {'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) throws Exception {
        init();
        printAllPassword(0);
        System.out.println(sb);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        bucket = new char[l];
        isVisit = new boolean[c];
        input = new char[c];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < c; i++) {
            input[i] = st.nextToken().toCharArray()[0];
        }
        Arrays.sort(input);
    }

    private static void printAllPassword(int depth) {
        if (depth == l) {
            int vowelCount = 0;
            for (int i = 0; i < l; i++) {
                if (isHasVowel(bucket[i])) {
                    vowelCount++;
                }
            }
            if (vowelCount == 0 || vowelCount > l - 2) {
                return ;
            }
            for(int i = 0; i < l; i++) {
                sb.append(bucket[i]);
            }
            sb.append("\n");
            return ;
        }
        for(int i = depth; i < c; i++) {
            if (isVisit[i] ||( depth >= 1 && Character.compare(bucket[depth - 1], input[i]) > 0)) {
                continue;
            }
            isVisit[i] = true;
            bucket[depth] = input[i];
            printAllPassword(depth + 1);
            isVisit[i] = false;
        }
    }

    private static boolean isHasVowel(char c) {
        for(int i = 0; i < vowel.length; i++) {
            if (vowel[i] == c) {
                return true;
            }
        }
        return false;
    }
}
