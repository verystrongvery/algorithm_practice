import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

class Solution {
    List<Integer>[] bannedIdsIdx;
    Set<String> answers = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        computeBannedIds(user_id, banned_id);
        solve(0, "");
        return answers.size();
    }

    private void computeBannedIds(String[] user_id, String[] banned_id) {
        bannedIdsIdx = new List[banned_id.length];
        for(int i = 0; i < banned_id.length; i++) {
            bannedIdsIdx[i] = new ArrayList<>();
            for (int j = 0; j < user_id.length; j++) {
                if (isBan(user_id[j], banned_id[i])) {
                    bannedIdsIdx[i].add(j);
                }
            }
        }
    }

    private boolean isBan(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }
        for(int i = 0; i < userId.length(); i++) {
            if (userId.charAt(i) != bannedId.charAt(i) && bannedId.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    private void solve(int depth, String userIdsIdx) {
        if (depth == bannedIdsIdx.length) {
            int userIdsCount = (int) userIdsIdx.chars()
                    .distinct()
                    .count();
            if (userIdsCount == bannedIdsIdx.length) {
                String answer = userIdsIdx.chars()
                        .mapToObj(c -> String.valueOf(c))
                        .sorted()
                        .collect(Collectors.joining());
                answers.add(answer);
            }
            return ;
        }
        List<Integer> idsIdx = bannedIdsIdx[depth];
        for(int i = 0; i < idsIdx.size(); i++) {
            solve(depth + 1, userIdsIdx + idsIdx.get(i));
        }
    }
}
