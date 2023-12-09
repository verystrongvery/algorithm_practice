import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.List;

class Node implements Comparable<Node> {
    int n;
    int count;

    public Node (int n, int count) {
        this.n = n;
        this.count = count;
    }

    @Override
    public int compareTo(Node n) {
        return Integer.compare(n.count, count);
    }
}

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : tangerine) {
            int value = map.getOrDefault(n, 0);
            map.put(n, value + 1);
        }
        List<Node> nodeList = map.entrySet()
                .stream()
                .map(es -> new Node(es.getKey().intValue(), es.getValue().intValue()))
                .sorted()
                .collect(Collectors.toList());
        int answer = 0;
        while (k > 0) {
            k -= nodeList.get(answer++).count;
        }
        return answer;
    }
}
