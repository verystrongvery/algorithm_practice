import java.io.*;
import java.util.*;
class Main {
    private static int n;
    private static int[] sequence = new int[1000000];
    private static int[] LIS = new int[1000000];
    public static void main(String[] args) throws Exception {
        init();
        int output = findLIS();
        System.out.println(output);
    }
    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }
    private static int findLIS() {
        int output = 1;
        LIS[0] = sequence[0];
        for(int i = 1; i < n; i++) {
            if (LIS[output - 1] < sequence[i]) {
                LIS[output++] = sequence[i];
                continue;
            }
            int largerAndClosetSequenceIndex = findLargerAndClosetSequenceIndex(sequence[i], output);
            LIS[largerAndClosetSequenceIndex] = sequence[i];
        }
        return output;
    }
    private static int findLargerAndClosetSequenceIndex(int target, int right) {
        int left = 0;
        while(left < right) {
            int mid = (left + right) / 2;
            if(target <= LIS[mid]) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }
}
