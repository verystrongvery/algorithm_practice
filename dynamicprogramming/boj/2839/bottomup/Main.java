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
        for(int i = 6; i <= input; i++) {
            memoization[i] = Math.min(memoization[i - 3], memoization[i - 5]) + 1;
        }
        int output = memoization[input] >= INPUT_MAX_SIZE ? -1 : memoization[input];
        System.out.println(output);
    }
}