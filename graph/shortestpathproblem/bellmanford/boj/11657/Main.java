import java.io.*;
import java.util.*;

class City implements Comparable<City>{
    int index;
    int time;

    public City(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(City c) {
        return Integer.compare(this.time, c.time);
    }

}
class Main {
    private static int n, m;
    private static List<City>[] buses = new ArrayList[501];
    private static long[] shortestPath = new long[501];
    private static long INF = 987654321987654321L;

    public static void  main(String[] args) throws Exception {
        init();
        boolean isCycle = bellmanFord();
        if (isCycle) {
            System.out.println(-1);
            return ;
        }
        printResult();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++) {
            buses[i] = new ArrayList<>();
            shortestPath[i] = INF;
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken());
            int city2 = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            buses[city1].add(new City(city2, time));
        }
        shortestPath[1] = 0;
    }

    private static boolean bellmanFord() {
        for(int i = 1; i <= n; i++) {
            boolean isUpdate = false;
            for (int j = 1; j <= n ; j++) {
                if (shortestPath[j] >= INF) {
                    continue;
                }
                for (int k = 0; k < buses[j].size(); k++) {
                    City cur = buses[j].get(k);
                    if (shortestPath[cur.index] <= shortestPath[j] + cur.time){
                        continue;
                    }
                    shortestPath[cur.index] = shortestPath[j] + cur.time;
                    isUpdate = true;
                }
            }
            if (!isUpdate) {
                return false;
            }
        }
        return true;
    }

    private static void printResult() {
        for(int i = 2; i <= n; i++) {
            if (shortestPath[i] == INF) {
                System.out.println(-1);
                continue;
            }
            System.out.println(shortestPath[i]);
        }
    }
}
