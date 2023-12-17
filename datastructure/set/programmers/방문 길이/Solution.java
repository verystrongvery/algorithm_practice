import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

class Pos {
    int x;
    int y;
    int nextX;
    int nextY;

    public Pos(int x, int y, int nextX, int nextY) {
        this.x = x;
        this.y = y;
        this.nextX = nextX;
        this.nextY = nextY;
    }

    @Override
    public boolean equals(Object o) {
        Pos pos = (Pos)o;
        if (x == pos.x && y == pos.y && nextX == pos.nextX && nextY == pos.nextY) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(x, y, nextX, nextY);
    }
}

class Solution {
    int x = 0;
    int y = 0;
    public int solution(String dirs) {
        Set<Pos> set = new HashSet<>();
        for(String dir : dirs.split("")) {
            move(set, dir);
        }
        return set.size() / 2;
    }

    public void move(Set<Pos> set, String dir) {
        int nextX = x;
        int nextY = y;
        if (dir.equals("U") && y + 1 <= 5) {
            nextY++;
        }
        else if (dir.equals("D") && y - 1 >= -5) {
            nextY--;
        }
        else if (dir.equals("L") && x - 1 >= -5) {
            nextX--;
        }
        else if (dir.equals("R") && x + 1 <= 5){
            nextX++;
        }
        if (x == nextX && y == nextY) {
            return ;
        }
        set.add(new Pos(x, y, nextX, nextY));
        set.add(new Pos(nextX, nextY, x, y));
        x = nextX;
        y = nextY;
    }
}