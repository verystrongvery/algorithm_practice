import java.io.*;
import java.util.*;
class Main{
    private static final long INF = 7654321234567L;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int V;
    private static long[][] shortestPath = new long[401][401];
    public static void main(String[] args) throws Exception {
        init();
        floydWarshall();
        long output = findMinCycle();
        System.out.println(output);
    }

    private static void init() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= V; i++) {
            for(int j = 1; j <= V; j++) {
                shortestPath[i][j] = INF;
            }
        }
        int E = Integer.parseInt(st.nextToken());
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            shortestPath[a][b] = Math.min(shortestPath[a][b], c);
        }
    }

    private static void floydWarshall() {
        for(int i = 1; i <= V; i++) {
            for(int j = 1; j <= V; j++) {
                for(int k = 1; k <= V; k++) {
                    if (shortestPath[j][k] <= shortestPath[j][i] + shortestPath[i][k]) {
                        continue;
                    }
                    shortestPath[j][k] = shortestPath[j][i] + shortestPath[i][k];
                }
            }
        }
    }

    private static long findMinCycle() {
        long result = INF;
        for(int i = 1; i <= V; i++) {
            result = Math.min(result, shortestPath[i][i]);
        }
        if (result == INF) {
            result = -1;
        }
        return result;
    }
}
