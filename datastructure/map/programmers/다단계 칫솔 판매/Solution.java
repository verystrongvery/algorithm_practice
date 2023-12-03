import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Node {
    int money;
    String parentName;

    public Node(String parentName) {
        money = 0;
        this.parentName = parentName;
    }
}
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Node> nodes = initNode(enroll, referral);
        computeMoney(nodes, seller, amount);
        return Arrays.stream(enroll)
                .mapToInt(e -> nodes.get(e).money)
                .toArray();
    }

    private Map initNode(String[] enroll, String[] referral) {
        Map<String, Node> nodes = new HashMap<>();
        nodes.put("root", new Node("root"));
        for(int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-")) {
                nodes.put(enroll[i], new Node("root"));
            }
            else {
                nodes.put(enroll[i], new Node(referral[i]));
            }
        }
        return nodes;
    }

    private void computeMoney(Map<String, Node> nodes, String[] seller, int[] amount) {
        for(int i = 0; i < seller.length; i++) {
            Node cur = nodes.get(seller[i]);
            int money = amount[i] * 100;
            int parentMoney = money / 10;
            money -= parentMoney;
            while(true) {
                cur.money += money;
                if (cur.parentName.equals("root")) {
                    break ;
                }
                cur = nodes.get(cur.parentName);
                money = parentMoney;
                parentMoney = money / 10;
                money -= parentMoney;
                if (money == 0) {
                    break ;
                }
            }
        }
    }
}
