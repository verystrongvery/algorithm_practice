class Solution {
    public int solution(int sticker[]) {
        if (sticker.length <= 3) {
            int answer = 0;
            for(int s : sticker) {
                answer = Math.max(answer, s);
            }
            return answer;
        }
        int answer1 = 0;
        int answer2 = 0;
        int bucket1 = sticker[0] + sticker[2];
        int bucket2 = sticker[0];
        int bucket3 = sticker[2];
        int bucket4 = sticker[1];
        for(int i = 3; i < sticker.length - 1; i++) {
            int temp = bucket1;
            bucket1 = bucket2 + sticker[i];
            bucket2 = Math.max(temp, bucket2);
            temp = bucket3;
            bucket3 = bucket4 + sticker[i];
            bucket4 = Math.max(temp, bucket4);
        }
        answer1 = Math.max(bucket1, bucket2);
        answer2 = Math.max(bucket4 + sticker[sticker.length - 1], bucket3);
        return Math.max(answer1, answer2);
    }
}
