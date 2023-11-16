import java.util.*;
import java.io.*;

class City implements Comparable<City>{
    int index;
    long time;

    public City(int index, long time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(City c) {
        return Long.compare(this.time, c.time);
    }
}
class Main {
    private static final long INF = 7654321234567L;
    private static int N, M, X;
    private static long[][] shortestPath = new long[1001][1001];
    private static List<City>[] cities = new ArrayList[1001];
    public static void main(String[] args) throws Exception {
        init();
        for(int i = 1; i <= N; i++) {
            dijkstra(i);
        }
        printResult();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++) {
            cities[i] = new ArrayList<>();
            for(int j = 1; j <= N; j++) {
                shortestPath[i][j] = INF;
            }
            shortestPath[i][i] = 0;
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            cities[a].add(new City(b, time));
        }
    }

    private static void dijkstra(int startCity) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(startCity, 0));
        while(!pq.isEmpty()) {
            City cur = pq.poll();
            if (cur.time > shortestPath[startCity][cur.index]) {
                continue;
            }
            for(int i = 0; i < cities[cur.index].size(); i++) {
                City next = cities[cur.index].get(i);
                if (shortestPath[startCity][next.index] <= cur.time + next.time) {
                    continue;
                }
                shortestPath[startCity][next.index] = cur.time + next.time;
                pq.add(new City(next.index, shortestPath[startCity][next.index]));
            }
        }
    }

    private static void printResult() {
        long[] shortestPathSum = new long[N + 1];
        long result = 0L;
        for(int i = 1; i <= N; i++) {
            shortestPathSum[i] += shortestPath[i][X];
            shortestPathSum[i] += shortestPath[X][i];
            result = Math.max(result, shortestPathSum[i]);
        }
        System.out.println(result);
    }
}
