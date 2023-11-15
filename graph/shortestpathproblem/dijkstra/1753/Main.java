import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.weight, o.weight);
    }
}
class Main {
    static int v, e, k;
    static List<Node>[] nodes = new ArrayList[20001];
    static int[] shortestPath = new int[20001];
    static int INF = 987654321;
    public static void main(String[] args) throws Exception {
        init();
        dijkstra();
        printResult();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        for(int i = 1; i <= v; i++) {
            nodes[i] = new ArrayList<Node>();
            shortestPath[i] = INF;
        }
        shortestPath[k] = 0;
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[vertex1].add(new Node(vertex2, weight));
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            for(int i = 0; i < nodes[cur.index].size(); i++) {
                Node next = nodes[cur.index].get(i);
                if (cur.weight + next.weight >= shortestPath[next.index]) {
                    continue;
                }
                shortestPath[next.index] = cur.weight + next.weight;
                pq.offer(new Node(next.index, shortestPath[next.index]));
            }
        }
    }
    private static void printResult() {
        for(int i = 1; i <= v; i++) {
            if (shortestPath[i] == INF) {
                System.out.println("INF");
                continue;
            }
            System.out.println(shortestPath[i]);
        }
    }
}
