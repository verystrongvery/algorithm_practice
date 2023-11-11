import java.util.Scanner;
class Main {
    private static final int INPUT_MAX = 1000000;
    private static long[] memo = new long[INPUT_MAX + 1];
    public static void main(String[] args) {
        int input = init();
        solve(input);
    }

    private static int init() {
        for(int i = 0; i <= INPUT_MAX; i++) {
            memo[i] = INPUT_MAX;
        }
        memo[1] = 0;
        memo[2] = 1;
        memo[3] = 1;
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void solve(int input) {
        for(int i = 4; i <= input; i++) {
            long output1 = i % 3 == 0 ? memo[i / 3] + 1 : INPUT_MAX;
            long output2 = i % 2 == 0 ? memo[i / 2] + 1 : INPUT_MAX;
            long output3 = memo[i - 1] + 1;
            memo[i] = Math.min(output1, Math.min(output2, output3));
        }
        System.out.println(memo[input]);
    }
}