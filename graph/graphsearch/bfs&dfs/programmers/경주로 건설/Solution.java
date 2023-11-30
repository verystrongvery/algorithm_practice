import java.util.Arrays;

class Solution {
    private int[][][] answers;
    private int[] dx = new int[]{-1, 0, 0, 1};
    private int[] dy = new int[]{0, -1, 1, 0};

    public int solution(int[][] board) {
        init(board.length, board[0].length);
        dfs(0, 0, board);
        return computeAnswer(board);
    }

    private void init(int rowSize, int colSize) {
        answers = new int[rowSize][colSize][4];
        for(int i = 0; i < rowSize; i++) {
            for(int j = 0; j < colSize; j++) {
                Arrays.fill(answers[i][j], 987654321);
            }
        }
        answers[0][0][0] = 0;
        answers[0][0][1] = 0;
        answers[0][0][2] = 0;
        answers[0][0][3] = 0;
    }

    private void dfs(int x, int y, int[][] board) {
        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextX >= board[0].length || nextY < 0 || nextY >= board.length || board[nextY][nextX] == 1) {
                continue;
            }
            for(int j = 0; j < 4; j++) {
                if (i == j) {
                    if (answers[nextY][nextX][i] > answers[y][x][j] + 100) {
                        answers[nextY][nextX][i] = answers[y][x][j] + 100;
                        dfs(nextX, nextY, board);
                    }
                    continue;
                }
                if (answers[nextY][nextX][i] > answers[y][x][j] + 600) {
                    answers[nextY][nextX][i] = answers[y][x][j] + 600;
                    dfs(nextX, nextY, board);
                }
            }
        }
    }

    private int computeAnswer(int[][] board) {
        int answer = 987654321;
        for(int i = 0; i < 4; i++) {
            answer = Math.min(answer, answers[board.length - 1][board[0].length - 1][i]);
        }
        return answer;
    }
}
