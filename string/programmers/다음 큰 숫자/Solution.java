class Solution {
    public int solution(int n) {
        int answer = n;
        String nStr = Integer.toBinaryString(n);
        while(true) {
            if (isAnswer(nStr, Integer.toBinaryString(++answer))) {
                break;
            }
        }
        return answer;
    }

    private boolean isAnswer(String s1, String s2) {
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '1') {
                count1++;
            }
        }
        for(int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == '1') {
                count2++;
            }
        }
        return count1 == count2;
    }
}
