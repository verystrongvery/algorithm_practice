import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    private List<String> result = new ArrayList<>();
    private Map<String, String> userIdToNickname = new HashMap<>();

    public String[] solution(String[] record) {
        for(String r : record) {
            analysis(r);
        }
        return result.stream()
                .map(this::userIdToNickname)
                .toArray(String[]::new);
    }

    private void analysis(String record) {
        String[] records = record.split(" ");
        if (records[0].equals("Leave")) {
            result.add(records[1] + "님이 나갔습니다.");
            return ;
        }
        if (records[0].equals("Enter")) {
            result.add(records[1] + "님이 들어왔습니다.");
        }
        userIdToNickname.put(records[1], records[2]);
    }

    private String userIdToNickname(String str) {
        int i = str.indexOf("님");
        String userId = str.substring(0, i);
        String sentence = str.substring(i, str.length());
        return userIdToNickname.get(userId) + sentence;
    }
}
