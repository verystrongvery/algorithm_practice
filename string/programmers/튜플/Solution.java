import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        List<List<String>> tuples = Arrays.stream(s.split("},"))
                .map(e -> e.replaceAll("[{}]", ""))
                .map(e -> Arrays.asList(e.split(",")))
                .collect(Collectors.toList());
        List<String>[] bucket = new List[tuples.size() + 1];
        tuples.forEach(tuple ->  bucket[tuple.size()] =  tuple);
        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i <= tuples.size(); i++) {
            for(String element : bucket[i]) {
                if (!answer.contains(Integer.parseInt(element))) {
                    answer.add(Integer.parseInt(element));
                    break ;
                }
            }
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
