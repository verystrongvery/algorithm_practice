class Solution {
import java.util.*;

    class Solution {
        public int solution(String s) {
            int answer = 0;
            for(int i = 0; i < s.length(); i++) {
                s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
                if (isCorrectBracketStr(s)) {
                    answer++;
                }
            }
            return answer;
        }

        private boolean isCorrectBracketStr(String s) {
            Stack<Character> st = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                if (!st.isEmpty() && isPairBracket(st.peek(), s.charAt(i))) {
                    st.pop();
                    continue;
                }
                st.push(s.charAt(i));
            }
            return st.isEmpty();
        }

        private boolean isPairBracket(char c1, char c2) {
            if (c1 == '(' && c2 == ')') {
                return true;
            }
            if (c1 == '[' && c2 == ']') {
                return true;
            }
            if (c1 == '{' && c2 == '}') {
                return true;
            }
            return false;
        }
    }
}
