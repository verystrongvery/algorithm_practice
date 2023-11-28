class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        quadCompression(0, 0, arr.length, arr);
        return answer;
    }

    private void quadCompression(int x, int y, int size, int[][] arr) {
        int standard = arr[y][x];
        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if (standard == arr[i][j]) {
                    continue;
                }
                quadCompression(x, y, size / 2, arr);
                quadCompression(x + size / 2, y , size / 2, arr);
                quadCompression(x, y + size / 2, size / 2, arr);
                quadCompression(x + size / 2, y + size / 2, size / 2, arr);
                return ;
            }
        }
        answer[standard]++;
    }
}
