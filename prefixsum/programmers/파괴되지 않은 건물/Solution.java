class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] prefixSum = new int [board.length + 1][board[0].length + 1];
        for(int i = 0; i < skill.length; i++) {
            useSkill(skill[i], prefixSum);
        }
        computePrefixSum(board, prefixSum);
        return countNotDestory(board);
    }

    private void useSkill(int[] skill, int[][] prefixSum) {
        if (skill[0] == 1) {
            attack(skill, prefixSum);
        }
        else if (skill[0] == 2) {
            recovery(skill, prefixSum);
        }
    }

    private void attack(int[] skill, int[][] prefixSum) {
        prefixSum[skill[1]][skill[2]] -= skill[5];
        prefixSum[skill[1]][skill[4] + 1] += skill[5];
        prefixSum[skill[3] + 1][skill[2]] += skill[5];
        prefixSum[skill[3] + 1][skill[4] + 1] -= skill[5];
    }

    private void recovery(int[] skill, int[][] prefixSum) {
        prefixSum[skill[1]][skill[2]] += skill[5];
        prefixSum[skill[1]][skill[4] + 1] -= skill[5];
        prefixSum[skill[3] + 1][skill[2]] -= skill[5];
        prefixSum[skill[3] + 1][skill[4] + 1] += skill[5];
    }

    private void computePrefixSum(int[][] board, int[][] prefixSum) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 1; j < board[0].length; j++) {
                prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }
        for(int i = 0; i < board[0].length; i++) {
            for(int j = 1; j < board.length; j++) {
                prefixSum[j][i] += prefixSum[j - 1][i];
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] += prefixSum[i][j];
            }
        }
    }

    private int countNotDestory(int[][] board) {
        int result = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
