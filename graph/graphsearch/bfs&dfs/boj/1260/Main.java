import java.util.*;
import java.io.*;
class Main {
    static int n, m, v;
    static boolean[][] graph = new boolean[1001][1001];
    static boolean[] isVisit;
    public static void main(String[] args) throws Exception {
        init();
        dfs();
        bfs();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            graph[vertex1][vertex2] = true;
            graph[vertex2][vertex1] = true;
        }
    }

    private static void dfs() {
        isVisit = new boolean[n + 1];
        dfs(v);
        System.out.println();
    }

    private static void dfs(int vertex) {
        isVisit[vertex] = true;
        System.out.print(vertex + " ");
        for(int i = 1; i <= n; i++) {
            if (graph[vertex][i] && !isVisit[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs() {
        isVisit = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        isVisit[v] = true;
        while(!q.isEmpty()) {
            int vertex = q.poll();
            System.out.print(vertex + " ");
            for(int i = 1; i <= n; i++) {
                if (!graph[vertex][i] || isVisit[i]) {
                    continue;
                }
                q.offer(i);
                isVisit[i] = true;
            }
        }
        System.out.println();
    }
}
