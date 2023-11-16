import java.io.*;
import java.util.*;

class Main {
    private static long INF = 7654321234567L;
    private static int n;
    private static long[][] shortestPath = new long[101][101];
    public static void main(String[] args) throws Exception {
        init();
        floydWarshall();
        printResult();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                shortestPath[i][j] = INF;
            }
            shortestPath[i][i] = 0;
        }
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
           shortestPath[a][b] = Math.min(shortestPath[a][b], c);
        }
    }

    private static void floydWarshall() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if (shortestPath[j][k] <= shortestPath[j][i] + shortestPath[i][k]) {
                        continue;
                    }
                    shortestPath[j][k] = shortestPath[j][i] + shortestPath[i][k];
                }
            }
        }
    }

    private static void printResult() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if (shortestPath[i][j] == INF) {
                    shortestPath[i][j] = 0;
                }
                System.out.print(shortestPath[i][j] + " ");
            }
            System.out.println();
        }
    }
}
