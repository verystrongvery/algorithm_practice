import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        Set<String> set = move(dirs);
        return set.size() / 2;
    }

    private Set<String> move(String dirs) {
        int posX = 0;
        int posY = 0;
        Set<String> set = new HashSet<>();
        for(char dir : dirs.toCharArray()) {
            int curX = posX;
            int curY = posY;
            if (dir == 'U' && curY < 5) {
                posY++;
            }
            else if (dir == 'D' && curY > -5) {
                posY--;
            }
            else if (dir == 'L' && curX > -5) {
                posX--;
            }
            else if (dir == 'R' && curX < 5) {
                posX++;
            }
            else {
                continue;
            }
            set.add("" + curX + curY + posX + posY);
            set.add("" + posX + posY + curX + curY);
        }
        return set;
    }
}
