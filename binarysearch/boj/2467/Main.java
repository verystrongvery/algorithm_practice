import java.io.*;
import java.util.*;
class Main{
    private static int INF = 1000000001;
    private static int n;
    private static int[] solution;
    public static void main(String[] args) throws Exception {
        init();
        findSolution();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        solution = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void findSolution() {
        int solutionAnswer1 = INF;
        int solutionAnswer2 = INF;
        for(int i = 0; i < n - 1; i++) {
            int solutionIndex = findSolutionIndex(i);
            if (Math.abs(solutionAnswer1 + solutionAnswer2) <= Math.abs(solution[i] + solution[solutionIndex])) {
                continue;
            }
            solutionAnswer1 = solution[i];
            solutionAnswer2 = solution[solutionIndex];
        }
        System.out.println(solutionAnswer1 + " " + solutionAnswer2);
    }

    private static int findSolutionIndex(int targetIndex) {
        int left = targetIndex + 1;
        int right = n - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if (solution[targetIndex] + solution[mid] <= 0) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }
        if (targetIndex + 1 == left) {
            return left;
        }
        return Math.abs(solution[targetIndex] + solution[left]) < Math.abs(solution[targetIndex] + solution[left - 1]) ? left : left - 1;
    }

}
