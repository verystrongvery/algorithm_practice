import java.util.Arrays;

class Solution {
    public int solution(int n, int k) {
        return (int)Arrays.stream(String.valueOf(Long.toString(n, k)).split("0"))
                .filter(str -> !str.equals(""))
                .filter(str -> isPrime(Long.parseLong(str)))
                .count();
    }

    private boolean isPrime(long n) {
        if (n == 1) {
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
