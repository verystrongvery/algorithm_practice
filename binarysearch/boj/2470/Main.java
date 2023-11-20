import java.io.*;
import java.util.*;
class Main {
    private static final int INF = 1000000000;
    private static int n;
    private static int[] data;
    public static void main(String[] args) throws Exception {
        init();
        findSolution();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        data = new int[n];
        for(int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
    }

    private static void findSolution() {
        int solutionAnswer1 = INF;
        int solutionAnswer2 = INF;
        for(int i = 0; i < n - 1; i++) {
            int solutionIndex = findSolutionIndex(i);
            if (Math.abs(data[i] + data[solutionIndex]) >= Math.abs(solutionAnswer1 + solutionAnswer2)) {
                continue;
            }
            solutionAnswer1 = data[i];
            solutionAnswer2 = data[solutionIndex];
        }
        System.out.println(solutionAnswer1 + " " + solutionAnswer2);
    }

    private static int findSolutionIndex(int targetIndex) {
        int left = targetIndex + 1;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (data[targetIndex] + data[mid] <= 0) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }
        if (left == targetIndex + 1) {
            return left;
        }
        return Math.abs(data[targetIndex] + data[left]) < Math.abs(data[targetIndex] + data[left - 1]) ? left : left - 1;
    }
}
