import java.io.*;
import java.util.*;

class Main {
    private static int n, m;
    private static StringBuilder sb = new StringBuilder();
    private static int[] sequence = new int[9];
    private static boolean[] isVisit = new boolean[9];
    public static void main(String[] args) throws Exception {
        init();
        printSequence(0);
        System.out.println(sb);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }

    private static void printSequence(int depth) {
        if (depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(sequence[i] + " ");
            }
            sb.append("\n");
        }
        for(int i = 1; i <= n; i++) {
            if (isVisit[i] || (depth != 0 && sequence[depth - 1] > i)) {
                continue;
            }
            isVisit[i] = true;
            sequence[depth] = i;
            printSequence(depth + 1);
            isVisit[i] = false;
        }
    }
}
