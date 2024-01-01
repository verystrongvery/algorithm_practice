// 1. 정답을 나타낼 String List 만들기
// 2. key는 유저아이디, value는 닉네임을 나타내는 Map 만들기

// 3. Enter : "Enter " + [유저아이디] 를 정답 List에 추가, 아이디와 닉네임을 Map에 추가
// 4. Leave : "Leave " + [유저아이디] 를 정답 List에 추가
// 5. Change : 아이디와 닉네임을 Map에 추가

// 6. 정답 List를 반복문을 통해 정답으로 바꾸기
// 6.1 "Enter " + [유저아이디] => [유저닉네임] + "님이 들어왔습니다." 
// 6.2 "Leave " + [유저아이디] => [유저닉네임] + "님이 나갔습니다."

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> idToNickname = new HashMap<>();
        for(String r : record) {
            cmd(r, answer, idToNickname);
        }
        return answer.stream()
                .map(str -> convertToAnswer(str, idToNickname))
                .toArray(String[]::new);
    }

    private void cmd(String record, List<String> answer, Map<String, String> idToNickname) {
        String[] records = record.split(" ");
        if (records[0].equals("Leave")) {
            answer.add("Leave " + records[1]);
            return ;
        }
        if (records[0].equals("Enter")) {
            answer.add("Enter " + records[1]);
        }
        idToNickname.put(records[1], records[2]);
    }

    private String convertToAnswer(String str, Map<String, String> idToNickname) {
        String[] s = str.split(" ");
        if (s[0].equals("Enter")) {
            return idToNickname.get(s[1]) + "님이 들어왔습니다.";
        }
        return idToNickname.get(s[1]) + "님이 나갔습니다.";
    }
}