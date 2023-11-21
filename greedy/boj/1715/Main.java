import java.io.*;
import java.util.*;
class Main {
    private static int n;
    private static Queue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        init();
        long answer = cardSort();
        System.out.println(answer);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            long cardCount = Long.parseLong(br.readLine());
            pq.offer(cardCount);
        }
    }

    private static long cardSort() {
        long answer = 0;
        while(pq.size() >= 2) {
            long cardList1 = pq.poll();
            long cardList2 = pq.poll();
            long combinedCardList = cardList1 + cardList2;
            answer += combinedCardList;
            pq.offer(combinedCardList);
        }
        return answer;
    }
}
