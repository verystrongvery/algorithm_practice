import java.io.*;
import java.util.*;

class Network implements Comparable<Network>{
    int from;
    int to;
    long cost;

    public Network(int from, int to, long cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Network n) {
        return Long.compare(this.cost, n.cost);
    }


}
class Main {
    private static int n, m;
    private static Queue<Network> pq = new PriorityQueue<>();
    private static int[] parent = new int[1001];
    public static void main(String[] args) throws Exception {
        init();
        long output = minimumSpanningTree();
        System.out.println(output);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Network(a, b, c));
        }
    }

    private static long minimumSpanningTree() {
        long output = 0;
        while(!pq.isEmpty()) {
            Network network = pq.poll();
            if (isSameParent(network.from, network.to)) {
                continue;
            }
            union(network.from, network.to);
            output += network.cost;
        }
        return output;
    }

    private static boolean isSameParent(int a, int b) {
        return findParent(a) == findParent(b);
    }

    private static int findParent(int child) {
        if (child == parent[child]) {
            return child;
        }
        parent[child] = findParent(parent[child]);
        return parent[child];
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
}
