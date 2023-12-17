import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class Solution {
    Map<Integer, Integer> entryTime = new ConcurrentHashMap<>();
    Map<Integer, Integer> totalTime = new TreeMap<>();

    public int[] solution(int[] fees, String[] records) {
        for(String record : records) {
            analyzeRecord(record);
        }
        entryTime.entrySet()
                .stream()
                .forEach(es -> analyzeRecord("23:59 " + es.getKey()));
        return totalTime.entrySet()
                .stream()
                .mapToInt(es -> computeFee(fees, es.getValue()))
                .toArray();
    }

    private void analyzeRecord(String record) {
        String[] r = record.split(" ");
        int carNum = Integer.parseInt(r[1]);
        int et = entryTime.getOrDefault(carNum, -1);
        if (et == -1) {
            entryTime.put(carNum, toIntTime(r[0]));
            return ;
        }
        entryTime.remove(carNum);
        int tt = totalTime.getOrDefault(carNum, 0);
        totalTime.put(carNum, tt + toIntTime(r[0]) - et);
    }

    private int toIntTime(String strTime) {
        String[] s = strTime.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    private int computeFee(int[] fees, int time) {
        if (fees[0] >= time){
            return fees[1];
        }
        time -= fees[0];
        if (time % fees[2] == 0) {
            return time / fees[2] * fees[3] + fees[1];
        }
        return (time / fees[2] + 1) * fees[3] + fees[1];
    }
}
