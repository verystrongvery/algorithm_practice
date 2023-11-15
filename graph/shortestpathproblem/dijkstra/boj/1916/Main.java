import java.io.*;
import java.util.*;

class City implements Comparable<City> {
    int index;
    long cost;

    public City(int index, long cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(City c) {
        return Long.compare(this.cost, c.cost);
    }
}
class Main {
    private static int n, m, src, dst;
    private static List<City>[] buses = new ArrayList[1001];
    private static long shortestPath[] = new long[1001];
    private static final long INF = 987654321;
    public static void main(String[] args) throws Exception {
        init();
        dijkstra();
        System.out.println(shortestPath[dst]);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) {
            buses[i] = new ArrayList();
            shortestPath[i] = INF;
        }
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            buses[city1].add(new City(city2, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        src = Integer.parseInt(st.nextToken());
        dst = Integer.parseInt(st.nextToken());
        shortestPath[src] = 0;
    }

    private static void dijkstra() {
        PriorityQueue<City> pq = new PriorityQueue<City>();
        pq.add(new City(src, 0));
        while(!pq.isEmpty()) {
            City cur = pq.poll();
            if (cur.cost > shortestPath[cur.index]) {
                continue;
            }
            for(int i = 0; i < buses[cur.index].size(); i++) {
                City next = buses[cur.index].get(i);
                if (shortestPath[next.index] <= cur.cost + next.cost) {
                    continue;
                }
                shortestPath[next.index] = cur.cost + next.cost;
                pq.offer(new City(next.index, shortestPath[next.index]));
            }
        }
    }
}
