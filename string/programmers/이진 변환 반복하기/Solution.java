class Solution {
    public int[] solution(String s) {
        int removeZeroCount = 0;
        int conversionCount = 0;
        while(!s.equals("1")) {
            String removedZeroStr = s.replace("0", "");
            removeZeroCount += (s.length() - removedZeroStr.length());
            s = Integer.toBinaryString(removedZeroStr.length());
            conversionCount++;
        }
        return new int[] {conversionCount, removeZeroCount};
    }
}
