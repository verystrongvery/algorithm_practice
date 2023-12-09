import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            String subStr1 = s.substring(0, i);
            String subStr2 = s.substring(i);
            String newStr = subStr2 + subStr1;
            if (isAnswer(newStr)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isAnswer(String str) {
        Stack<Character> s = new Stack<>();
        for(char c : str.toCharArray()) {
            if (s.isEmpty() || isAdd(s.peek(), c)) {
                s.add(c);
                continue;
            }
            s.pop();
        }
        return s.isEmpty();
    }

    private boolean isAdd(char peek, char c) {
        if (peek == '(' && c == ')') {
            return false;
        }
        if (peek == '[' && c == ']') {
            return false;
        }
        if (peek == '{' && c == '}') {
            return false;
        }
        return true;
    }
}
