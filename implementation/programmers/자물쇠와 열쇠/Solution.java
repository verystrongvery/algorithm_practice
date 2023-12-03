import java.util.Arrays;

class Solution {
    final int empty = 0;
    final int exist = 1;
    final int outside = 2;

    public boolean solution(int[][] key, int[][] lock) {
        int[][] newLock = initNewLock(lock, key.length);
        for(int i = 0; i < 4; i++) {
            key = lotation(key);
            if (isPossible(newLock, key, lock.length)) {
                return true;
            }
        }
        return false;
    }

    private int[][] initNewLock(int[][] lock, int n) {
        int newLockLength = lock.length + (n - 1) * 2;
        int[][] newLock = new int[newLockLength][newLockLength];
        for(int i = 0; i < newLockLength; i++) {
            Arrays.fill(newLock[i], outside);
        }
        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock.length; j++) {
                newLock[n - 1 + i][n - 1 + j] = lock[i][j];
            }
        }
        return newLock;
    }

    private int[][] lotation(int[][] key) {
        int[][] newKey = new int[key.length][key.length];
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                newKey[i][j] = key[key.length - 1 - j][i];
            }
        }
        return newKey;
    }

    private boolean isPossible(int[][] newLock, int[][] key, int lockLength) {
        for(int i = 0; i < lockLength + key.length - 1; i++) {
            for(int j = 0; j < lockLength + key.length - 1; j++) {
                if (isPossible(newLock, key, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPossible(int[][] newLock, int[][] key, int i, int j) {
        int[][] newLockCopy = new int[newLock.length][newLock.length];
        for(int k = 0; k < newLockCopy.length; k++) {
            for(int l = 0; l < newLockCopy.length; l++) {
                newLockCopy[k][l] = newLock[k][l];
            }
        }
        for(int k = 0; k < key.length; k++) {
            for(int l = 0; l < key.length; l++) {
                if (newLock[i + k][j + l] == empty && key[k][l] == empty) {
                    return false;
                }
                if (newLock[i + k][j + l] == exist && key[k][l] == exist) {
                    return false;
                }
                newLockCopy[i + k][j + l] = exist;
            }
        }
        for(int k = 0; k < newLockCopy.length; k++) {
            for(int l = 0; l < newLockCopy.length; l++) {
                if (newLockCopy[k][l] == empty) {
                    return false;
                }
            }
        }
        return true;
    }
}
