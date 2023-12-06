import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node>{
    int num;
    int x;
    int y;
    Node leftChild;
    Node rightChild;

    public Node(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    public int compareTo(Node n) {
        if (y != n.y) {
            return Integer.compare(n.y, y);
        }
        return Integer.compare(x, n.x);
    }

}
class Solution {
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodeList = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++) {
            nodeList.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        Collections.sort(nodeList);

        Node root = nodeList.get(0);
        for(int i = 1; i < nodeList.size(); i++) {
            makeTree(root, nodeList.get(i));
        }
        List<Integer> preorderBucket = new ArrayList<>();
        computePreorder(root, preorderBucket);
        List<Integer> postorderBucket = new ArrayList<>();
        computePostorder(root, postorderBucket);

        int[][] answer = new int[2][nodeinfo.length];
        int[] preorderAnswer = preorderBucket.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        int[] postorderAnswer = postorderBucket.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        answer[0] = preorderAnswer;
        answer[1] = postorderAnswer;
        return answer;
    }

    private void makeTree(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.leftChild == null) {
                parent.leftChild = child;
                return ;
            }
            makeTree(parent.leftChild, child);
            return ;
        }
        if (parent.rightChild == null) {
            parent.rightChild = child;
            return ;
        }
        makeTree(parent.rightChild, child);
    }

    private void computePreorder(Node node, List<Integer> bucket) {
        bucket.add(node.num);
        if (node.leftChild != null) {
            computePreorder(node.leftChild, bucket);
        }
        if (node.rightChild != null) {
            computePreorder(node.rightChild, bucket);
        }
    }

    private void computePostorder(Node node, List<Integer> bucket) {
        if (node.leftChild != null) {
            computePostorder(node.leftChild, bucket);
        }
        if (node.rightChild != null) {
            computePostorder(node.rightChild, bucket);
        }
        bucket.add(node.num);
    }
}
