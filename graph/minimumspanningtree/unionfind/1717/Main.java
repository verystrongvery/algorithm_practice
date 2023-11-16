import java.io.*;
import java.util.*;
class Main {
    private static int n;
    private static int[] parent = new int[1000001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int operationType = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (operationType == 0) {
                union(a, b);
                continue;
            }
            String sameParent = isSameParent(a, b);
            System.out.println(sameParent);
        }
    }

    private static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
            return ;
        }
        parent[a] = b;
    }

    private static int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    private static String isSameParent(int a, int b) {
        if (findParent(a) == findParent(b)) {
            return "YES";
        }
        return "NO";
    }
}
