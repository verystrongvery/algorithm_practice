class Solution {
    public int solution(String s){
        int answer = 1;
        for(int i = 0; i < s.length(); i++) {
            int j = 0;
            int palindromeSize = 1;
            while (i - (++j) >= 0 && i + j < s.length()) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                palindromeSize += 2;
            }
            answer = Math.max(answer, palindromeSize);
            if (i + 1 > s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                continue;
            }
            palindromeSize = 2;
            j = 0;
            while (i - (++j) >= 0 && i + 1 +j < s.length()) {
                if (s.charAt(i - j) != s.charAt(i + 1 + j)) {
                    break;
                }
                palindromeSize += 2;
            }
            answer = Math.max(answer, palindromeSize);
        }
        return answer;
    }
}
