import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int index;
    int time;

    public Node(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(Node n) {
        return Integer.compare(this.time, n.time);
    }
}
class Main {
    private static final long INF = 98765432123456789L;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long shortestPath[];
    private static List<Node>[] nodes;
    private static int N, M, T;
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String answer = bellmanFord();
            System.out.println(answer);
        }
    }

    private static String bellmanFord() throws Exception {
        init();
        for(int i = 0; i <= N; i++) {
            boolean isUpdate = false;
            for(int j = 1; j <= N; j++) {
//                if (shortestPath[j] >= INF) {
//                    continue ;
//                }
                for(int k = 0; k <nodes[j].size(); k++) {
                    Node next = nodes[j].get(k);
                    if (shortestPath[next.index] <= shortestPath[j] + next.time) {
                        continue;
                    }
                    isUpdate = true;
                    shortestPath[next.index] = shortestPath[j] + next.time;
                }
            }
            if (!isUpdate) {
                return "NO";
            }
        }
        return "YES";
    }

    private static void init() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        nodes = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        shortestPath = new long[N + 1];
        for(int i = 1; i <= N; i++) {
            shortestPath[i] = INF;
        }
        shortestPath[1] = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            nodes[S].add(new Node(E, T));
            nodes[E].add(new Node(S, T));
        }
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            nodes[S].add(new Node(E, -T));
        }
    }
}
