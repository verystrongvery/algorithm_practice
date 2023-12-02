import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Node implements Comparable<Node>{
    int key;
    int value;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Node n) {
        return Integer.compare(this.value, n.value);
    }
}

class Solution {
    final int INF = 987654321;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<Node>[] edges = init(n, s, fares);
        int[] shortestPathS = dijkstra(n, s, edges);
        int[] shortestPathA = dijkstra(n, a, edges);
        int[] shortestPathB = dijkstra(n, b, edges);
        int answer = INF;
        for(int i = 1; i <= n; i++) {
            if (shortestPathS[i] != INF && shortestPathA[i] != INF && shortestPathB[i] != INF) {
                answer = Math.min(answer, shortestPathS[i] + shortestPathA[i] + shortestPathB[i]);
            }
        }
        return answer;
    }

    private List<Node>[] init(int n, int s, int[][] fares) {
        List<Node>[] edges = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for(int i = 0; i < fares.length; i++) {
            edges[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
            edges[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
        }
        return edges;
    }

    private int[] dijkstra(int n, int s, List<Node>[] edges) {
        int[] shortestPath = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            shortestPath[i] = INF;
        }
        shortestPath[s] = 0;
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            for(Node next : edges[cur.key]) {
                if (shortestPath[next.key] <= cur.value + next.value) {
                    continue;
                }
                shortestPath[next.key] = cur.value + next.value;
                pq.offer(new Node(next.key, shortestPath[next.key]));
            }
        }
        return shortestPath;
    }

}
