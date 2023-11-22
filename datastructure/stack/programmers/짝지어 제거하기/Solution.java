import java.util.*;

class Solution
{
    Stack<Character> st = new Stack<>();
    public int solution(String s)
    {
        for(int i = 0; i < s.length(); i++) {
            removePairStr(s.charAt(i));
        }
        return st.isEmpty() ? 1 : 0;
    }

    private void removePairStr(char c) {
        if (!st.isEmpty() && st.peek() == c) {
            st.pop();
            return ;
        }
        st.push(c);
    }
}
