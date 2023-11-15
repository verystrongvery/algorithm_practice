import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
    int index;
    int dist;

    public Point(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    @Override
    public int compareTo(Point p) {
        return Integer.compare(this.dist, p.dist);
    }
}
class Main {
    private static final int INF = 100001;
    private static int n, k;
    private static int[] shortestPath = new int[INF + 1];

    public static void main(String[] args) throws Exception {
        init();
        int output = dijkstra();
        System.out.println(output);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < INF; i++) {
            shortestPath[i] = INF;
        }
        shortestPath[n] = 0;
    }

    private static int dijkstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(n, 0));
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.index == k) {
                return cur.dist;
            }
            if (cur.dist > shortestPath[cur.index]) {
                continue ;
            }
            if (cur.index - 1 >= 0 && shortestPath[cur.index - 1] > cur.dist + 1) {
                shortestPath[cur.index - 1] = cur.dist + 1;
                pq.offer(new Point(cur.index - 1, cur.dist + 1));
            }
            if (cur.index + 1 <= 100000 && shortestPath[cur.index + 1] > cur.dist + 1) {
                shortestPath[cur.index + 1] = cur.dist + 1;
                pq.offer(new Point(cur.index + 1, cur.dist + 1));
            }
            if (cur.index * 2 <= 100000 && shortestPath[cur.index * 2] > cur.dist) {
                shortestPath[cur.index * 2] = cur.dist;
                pq.offer(new Point(cur.index * 2, cur.dist));
            }
        }
        return 0;
    }
}
