// 1. 좌표에 대한 클래스 만들기

// 2. 지울 수 있는 좌표인지 확인하기

// 3. 지울 수 있는 좌표 지우기
// 3.1 지울 수 있는 좌표 모으기
// 3.2 지울 수 있는 좌표 한번에 지우기

// 4. 빈 공간 채우기

// 5. 지울 수 있는 블록이 있을때 까지 반복하기

import java.util.List;
import java.util.ArrayList;

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(int m, int n, String[] board) {
        String[][] boards = initBoards(board);
        while(true) {
            if (!removeBlock(boards)) {
                break ;
            }
            fillEmptySpace(boards);
        }
        return countAnswer(boards);
    }

    private String[][] initBoards(String[] board) {
        String[][] boards = new String[board.length][board[0].length()];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length(); j++) {
                boards[i][j] = String.valueOf(board[i].charAt(j));
            }
        }
        return boards;
    }

    private boolean removeBlock(String[][] board) {
        List<Pos> removePos = new ArrayList<>();
        for(int i = 0; i + 1 < board.length; i++) {
            for(int j = 0; j + 1 < board[0].length; j++) {
                if (!isRemovePossible(board, j, i)) {
                    continue;
                }
                removePos.add(new Pos(j, i));
                removePos.add(new Pos(j + 1, i));
                removePos.add(new Pos(j, i + 1));
                removePos.add(new Pos(j + 1, i + 1));
            }
        }
        if (removePos.isEmpty()) {
            return false;
        }
        removePos.forEach(pos -> board[pos.y][pos.x] = " ");
        return true;
    }

    private void fillEmptySpace(String[][] board) {
        for(int i = 0; i < board[0].length; i++) {
            for(int j = board.length - 1; j >= 0; j--) {
                if (board[j][i].equals(" ")) {
                    int k = j;
                    while(--k >= 0 && board[k][i] == " ") {}
                    if (k < 0) {
                        continue;
                    }
                    board[j][i] = board[k][i];
                    board[k][i] = " ";
                }
            }
        }
    }

    private boolean isRemovePossible(String[][] board, int x, int y) {
        if (board[y][x].equals(" ")) {
            return false;
        }
        if (y + 1 >= board.length || x + 1 >= board[0].length) {
            return false;
        }
        String block = board[y][x];
        if (!board[y][x + 1].equals(block) || !board[y + 1][x].equals(block) || !board[y + 1][x + 1].equals(block)) {
            return false;
        }
        return true;
    }

    private int countAnswer(String[][] boards) {
        int answer = 0;
        for(String[] bs : boards) {
            for(String b : bs) {
                if (b.equals(" ")) {
                    answer++;
                }
            }
        }
        return answer;
    }
}