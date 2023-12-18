import java.util.Stack;
import java.util.Arrays;

class Node {
    int index;
    int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Node> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        for(int i = 0; i < numbers.length; i++) {
            solve(numbers[i], i, answer, stack);
        }
        return answer;
    }

    private void solve(int num, int index, int[] answer, Stack<Node> stack) {
        if (stack.isEmpty() || stack.peek().value >= num) {
            stack.push(new Node(index, num));
            return ;
        }
        while(!stack.isEmpty() && stack.peek().value < num) {
            Node node = stack.pop();
            answer[node.index] = num;
        }
        stack.push(new Node(index, num));
    }
}