import java.util.Scanner;
class Main {
    private static final int INPUT_MAX_SIZE = 5000;
    private static int [] memoization =  new int[INPUT_MAX_SIZE + 1];
    public static void main(String[] args) {
        int input = init();
        solve(input);
    }

    private static int init() {
        for(int i = 0; i <= INPUT_MAX_SIZE; i++) {
            memoization[i] = INPUT_MAX_SIZE;
        }
        memoization[3] = 1;
        memoization[5] = 1;
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void solve(int input) {
        int output = dp(input);
        output = output >= INPUT_MAX_SIZE ? -1 : output;
        System.out.println(output);
    }

    private static int dp(int memoizationIndex) {
        if (memoizationIndex <= 5) {
            return  memoization[memoizationIndex];
        }
        int output1 = memoization[memoizationIndex-3] != INPUT_MAX_SIZE ? memoization[memoizationIndex-3] : dp(memoizationIndex - 3);
        int output2 = memoization[memoizationIndex-5] != INPUT_MAX_SIZE ? memoization[memoizationIndex-5] : dp(memoizationIndex - 5);

        int result = Math.min(output1, output2) + 1;
        memoization[memoizationIndex] = result;
        return result;
    }
}