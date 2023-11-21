class Solution {
    private int removedZeroCount = 0;
    public int[] solution(String s) {
        int binaryConvertCount = 0;
        while (!s.equals("1")) {
            s = binaryConvert(s);
            binaryConvertCount++;
        }
        return new int[] {binaryConvertCount, removedZeroCount};
    }

    private String binaryConvert(String s) {
        String removedZeroStr = s.replaceAll("0", "");
        removedZeroCount += (s.length() - removedZeroStr.length());
        return Integer.toBinaryString(removedZeroStr.length());
    }
}
