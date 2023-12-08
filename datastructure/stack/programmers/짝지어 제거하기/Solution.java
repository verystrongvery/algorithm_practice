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

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
