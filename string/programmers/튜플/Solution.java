import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        List<String> list = Arrays.stream(s.split("},"))
                .map(str -> str.replaceAll("[{}]",""))
                .collect(Collectors.toList());
        List<Integer>[] answerArray = new ArrayList[list.size() + 1];
        list.stream()
                .map(this:: toList)
                .forEach(l -> answerArray[l.size()] = l);
        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i < answerArray.length; i++) {
            for(int j = 0; j < answerArray[i].size(); j++) {
                if (!answer.contains(answerArray[i].get(j))) {
                    answer.add(answerArray[i].get(j));
                    break;
                }
            }
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private List<Integer> toList(String str) {
        return Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
