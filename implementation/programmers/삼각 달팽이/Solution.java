// 1. 아래로 n칸 이동하면서 1씩 증가
// 2. 오른쪽으로 n-1칸 이동하면서 1씩 증가
// 3. 왼쪽위로 n-2칸 이동하면서 1씩 증가
// 4. 모두 그릴때 까지 반복

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int x = 0;
        int y = -1;
        int num = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                if (i % 3 == 0) {
                    arr[++y][x] = ++num;
                }
                else if (i % 3 == 1) {
                    arr[y][++x] = ++num;
                }
                else {
                    arr[--y][--x] = ++num;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                list.add(arr[i][j]);
            }
        }
        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}