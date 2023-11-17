import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int from;
    int to;
    long weight;
    public Node(int from, int to, long weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node n) {
        return Long.compare(this.weight, n.weight);
    }

}
class Main {
    private static int V, E;
    private static int parent[] = new int[10001];
    private static Queue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        init();
        long output = minimumSpanningTree();
        System.out.println(output);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        for(int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a, b, c));
        }
    }
    private static long minimumSpanningTree() {
        int output = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(isSameParent(node.to, node.from)) {
                continue;
            }
            output += node.weight;
            union(node.to, node.from);
        }
        return output;
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

    private static int findParent(int child) {
        if (child == parent[child]) {
            return child;
        }
        parent[child] = findParent(parent[child]);
        return parent[child];
    }
    private static boolean isSameParent(int a, int b) {
        return findParent(a) == findParent(b);
    }
}
