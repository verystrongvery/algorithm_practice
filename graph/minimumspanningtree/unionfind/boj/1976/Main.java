import java.io.*;
import java.util.*;
class Main {
    private static int n, m;
    private static int[] travelCities = new int[1001];
    private static int[] parent = new int[201];
    public static void main(String[] args) throws Exception {
        init();
        boolean isPossibleTravel = computeIsPossibleTravel();
        String result = isPossibleTravel ? "YES" : "NO";
        System.out.println(result);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <=n; j++) {
                int isConnected = Integer.parseInt(st.nextToken());
                if (isConnected == 0) {
                    continue;
                }
                union(i, j);
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            travelCities[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static boolean computeIsPossibleTravel() {
        for(int i = 1; i < m; i++) {
            if (!isSameParent(travelCities[i - 1], travelCities[i])) {
                return false;
            }
        }
        return true;
    }

    private static void union(int i, int j) {
        i = findParent(i);
        j = findParent(j);
        if (i < j) {
            parent[j] = i;
            return ;
        }
        parent[i] = j;
    }

    private static int findParent(int child) {
        if (child == parent[child]) {
            return child;
        }
        parent[child] = findParent(parent[child]);
        return parent[child];
    }

    private static boolean isSameParent(int i, int j) {
        return findParent(i) == findParent(j);
    }
}
