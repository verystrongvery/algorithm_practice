// 1. 4구역이 모두 같으면 분할 x
// 1.1 1 또는 0 개수 세기

// 2. 4구역이 모두 같지 않으면 분할
class Solution {

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        compression(0, 0, arr.length, arr, answer);
        return answer;
    }

    private void compression(int x, int y, int len, int[][] arr, int[] answer) {
        int benchmark = arr[y][x];
        for(int i = y; i < y + len; i++) {
            for(int j = x; j < x + len; j++) {
                if(arr[i][j] == benchmark) {
                    continue;
                }
                compression(x, y, len / 2, arr, answer);
                compression(x + len / 2, y, len / 2, arr, answer);
                compression(x, y + len / 2, len / 2, arr, answer);
                compression(x + len / 2, y + len / 2, len / 2, arr, answer);
                return ;
            }
        }
        answer[benchmark]++;
    }
}