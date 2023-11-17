import java.io.*;
import java.util.*;
class Main {
    private static int n;
    private static List<Integer>[] graph = new ArrayList[32001];
    private static int[] indegree = new int[32001];
    public static void main(String[] args) throws Exception {
        init();
        topologySort();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }
    }

    private static void topologySort() {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            System.out.print(cur + " ");
            for(int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                indegree[next]--;
                if (indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }
    }
}
