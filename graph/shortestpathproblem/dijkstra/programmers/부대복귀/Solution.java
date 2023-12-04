import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    final int INF = 987654321;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] path = initPath(n, roads);
        final int[] shortestPath = initShortestPath(n, destination);
        dijkstra(n, destination, path, shortestPath);
        return Arrays.stream(sources)
                .map(s -> toShortestPath(s, shortestPath))
                .toArray();
    }

    private List<Integer>[] initPath(int n, int[][] roads) {
        List<Integer>[] path = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            path[i] = new ArrayList<>();
        }
        for(int i = 0; i < roads.length; i++) {
            path[roads[i][0]].add(roads[i][1]);
            path[roads[i][1]].add(roads[i][0]);
        }
        return path;
    }

    private int[] initShortestPath(int n, int destination) {
        int[] shortestPath = new int[n + 1];
        for(int i = 1; i <= n ; i++) {
            shortestPath[i] = INF;
        }
        shortestPath[destination] = 0;
        return shortestPath;
    }

    private void dijkstra(int n, int destination, List<Integer>[] path, int[] shortestPath) {
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 0; i < path[cur].size(); i++) {
                int next = path[cur].get(i);
                if (shortestPath[next] <= shortestPath[cur] + 1) {
                    continue;
                }
                shortestPath[next] = shortestPath[cur] + 1;
                q.offer(next);
            }
        }
    }

    private int toShortestPath(int source, int[] shortestPath) {
        if (shortestPath[source] == INF) {
            return -1;
        }
        return shortestPath[source];
    }
}
