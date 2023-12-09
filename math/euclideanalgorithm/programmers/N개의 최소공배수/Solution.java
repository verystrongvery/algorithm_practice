class Solution {
    public int solution(int[] arr) {
        int gcm = arr[0];
        for(int i = 1; i < arr.length; i++) {
            gcm = findGcm(gcm, arr[i]);
        }
        return gcm;
    }

    private int findGcm(int n1, int n2) {
        int gcd = findGcd(n1, n2);
        return n1 * n2 / gcd;
    }

    private int findGcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return findGcd(n2, n1 % n2);
    }
}
