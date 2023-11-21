import java.io.*;
import java.util.*;
class Main {
    private static int n;
    private static int result = 0;
    private static boolean[][] chessBoard = new boolean[15][15];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        computeNQueen(0);
        System.out.println(result);
    }

    private static void computeNQueen(int depth) {
        if (depth == n) {
            result++;
            return ;
        }
        for(int i = 1; i <= n; i++) {
            boolean locationPossible = isLocationPossible(i, depth + 1);
            if (!locationPossible) {
                continue;
            }
            chessBoard[depth + 1][i] = true;
            computeNQueen(depth + 1);
            chessBoard[depth + 1][i] = false;
        }
    }

    private static boolean isLocationPossible(int i, int depth) {
        for(int j = 1; j <= n; j++) {
            boolean locationPossible = isLocationPossible(i, j, depth);
            if (!locationPossible) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLocationPossible(int i, int j, int depth) {
        if (chessBoard[j][i]) {
            return false;
        }
        if (depth - j >= 1 && i - j >= 1 && chessBoard[depth - j][i - j]) {
            return false;
        }
        if (depth - j >= 1 && i + j <= n && chessBoard[depth - j][i + j]) {
            return false;
        }
        return true;
    }

}
