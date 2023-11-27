import java.util.Queue;
import java.util.LinkedList;

class Position {
    int x;
    int y;

    public Position(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    char[][] blocks;
    final char blank = '-';
    public int solution(int m, int n, String[] board) {
        initBlock(m, n, board);
        int answer = 0;
        while (true) {
            int clearBlockCount = clearBlocks(m, n);
            answer += clearBlockCount;
            if (clearBlockCount == 0) {
                break;
            }
            shiftClearedBlocks(m, n);
        }
        return answer;
    }

    private void initBlock(int m, int n, String[] board) {
        blocks = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                blocks[i][j] = board[i].charAt(j);
            }
        }
    }

    private int clearBlocks(int m, int n) {
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (isClearPossible(i, j, m, n)) {
                    result += clearBlocks(i, j, m, n);
                }
            }
        }
        return result;
    }

    private int clearBlocks(int i, int j, int m, int n) {
        int result = 0;
        char c = blocks[i][j];
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(i, j));
        while (!q.isEmpty()) {
            Position position = q.poll();
            int x = position.x;
            int y = position.y;
            if (blocks[y][x] == blank) {
                continue;
            }
            blocks[y][x] = blank;
            result++;
            if (y + 1 < m && x + 1 < n && blocks[y + 1][x] == c && blocks[y ][x + 1] == c && blocks[y + 1][x + 1] == c) {
                q.offer(new Position(y + 1, x));
                q.offer(new Position(y, x + 1));
                q.offer(new Position(y + 1, x + 1));
            }

        }
        return result;
    }

    private boolean isClearPossible(int i, int j, int m, int n) {
        char c = blocks[i][j];
        if (c == blank || i + 1 == m || j + 1 == n || blocks[i + 1][j] != c || blocks[i][j + 1] != c || blocks[i + 1][j + 1] != c) {
            return false;
        }
        return true;
    }

    private void shiftClearedBlocks(int m, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = m - 1; j > 0; j--) {
                if (blocks[j - 1][i] != blank && blocks[j][i] == blank) {
                    int yIndex = j;
                    while (yIndex < m && blocks[yIndex][i] == blank) {
                        yIndex++;
                    }
                    blocks[yIndex - 1][i] = blocks[j - 1][i];
                    blocks[j - 1][i] = blank;
                }
            }
        }
    }
}
