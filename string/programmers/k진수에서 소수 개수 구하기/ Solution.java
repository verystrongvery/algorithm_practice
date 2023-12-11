import java.util.Arrays;

class Solution {
    public int solution(int n, int k) {
        return (int)Arrays.stream(Long.toString(n, k).split("0"))
                .filter(s -> !s.equals(""))
                .filter(s -> isPrime(Long.parseLong(s)))
                .count();
    }

    private boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        for(long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
