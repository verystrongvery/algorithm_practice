import java.util.Stack;

class Solution{
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            removePairStr(stack, c);
        }
        return stack.isEmpty() ? 1 : 0;
    }

    private void removePairStr(Stack<Character> stack, char c) {
        if (stack.isEmpty() || stack.peek() != c) {
            stack.push(c);
            return ;
        }
        stack.pop();
    }
}
