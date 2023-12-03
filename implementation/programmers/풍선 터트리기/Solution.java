class Solution {
    public int solution(int[] a) {
        int minArray1[] = new int[a.length];
        int minArray2[] = new int[a.length];
        minArray1[0] = a[0];
        minArray2[a.length - 1] = a[a.length - 1];
        for(int i = 1; i < minArray1.length; i++) {
            minArray1[i] = Math.min(minArray1[i - 1], a[i]);
            minArray2[a.length - 1 - i] = Math.min(minArray2[a.length - i], a[a.length - 1 - i]);
        }
        int answer = 0;
        for(int i = 0; i < a.length; i++) {
            if (a[i] <= minArray1[i] || a[i] <= minArray2[i]) {
                answer++;
            }
        }
        return answer;
    }
}
