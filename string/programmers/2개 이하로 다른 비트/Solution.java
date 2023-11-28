import java.util.Arrays;

class Solution {
    public long[] solution(long[] numbers) {
        return Arrays.stream(numbers)
                .map(this::solve)
                .toArray();
    }

    private long solve(long number) {
        String binaryString = Long.toBinaryString(number);
        int i = binaryString.length();
        while(true) {
            if (--i < 0) {
                binaryString = "10" + binaryString.substring(1, binaryString.length());
                break;
            }
            if (binaryString.charAt(i) == '0' && i != binaryString.length() - 1) {
                binaryString = binaryString.substring(0, i) + "10" + binaryString.substring(i + 2, binaryString.length());
                break ;
            }
            if (binaryString.charAt(i) == '0' && i == binaryString.length() - 1) {
                binaryString = binaryString.substring(0, binaryString.length() - 1) + "1";
                break ;
            }
        }
        return Long.parseLong(binaryString, 2);
    }
}
