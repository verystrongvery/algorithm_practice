import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        int map[][] = new int[n][n];
        int x = 0;
        int y = -1;
        int num = 0;
        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < n - i; j++) {
                if(i % 3 == 0) {
                    y++;
                }
                else if(i % 3 == 1) {
                    x++;
                }
                else {
                    x--;
                    y--;
                }
                map[y][x] = ++num;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                list.add(map[i][j]);
            }
        }
        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
