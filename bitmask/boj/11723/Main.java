import java.io.*;
import java.util.*;
class Main {
    static int result = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        for(int i= 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (st.countTokens() == 0) {
                calculate(cmd);
                continue;
            }
            int x = Integer.parseInt(st.nextToken());
            calculate(cmd, x);
        }
        System.out.println(sb);
    }

    private static void calculate(String cmd) {
        if (cmd.equals("all")) {
            result = (1 << 21) - 1;
        }
        else if (cmd.equals("empty")) {
            result = 0;
        }
    }

    private static void calculate(String cmd, int x) {
        if (cmd.equals("add")) {
            result |= (1 << x);
        }
        else if (cmd.equals("remove")) {
            result &= ~(1 << x);
        }
        else if (cmd.equals("check")) {
            sb.append((result & (1 << x)) == 1 << x ? 1 : 0).append("\n");
        }
        else if (cmd.equals("toggle")) {
            result ^= (1 << x);
        }
    }
}
