import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    int lastBusLastTime = 0;
    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);
        List<Integer> busTime = IntStream.range(0, n)
                .mapToObj(i -> timeToInt("09:00") + i * t)
                .collect(Collectors.toList());
        List<Integer> remainSeat = IntStream.range(0, n)
                .mapToObj(i -> m)
                .collect(Collectors.toList());
        Arrays.stream(timetable)
                .forEach(humanTime ->  computeRemainSeat(timeToInt(humanTime), busTime, remainSeat));
        if (remainSeat.get(n -1) != 0) {
            return timeToString(busTime.get(n - 1));
        }
        return timeToString(lastBusLastTime - 1);
    }

    private int timeToInt(String time) {
        String[] hoursAndMinutes = time.split(":");
        int hours = Integer.parseInt(hoursAndMinutes[0]);
        int minutes = Integer.parseInt(hoursAndMinutes[1]);
        return hours * 60 + minutes;
    }

    private String timeToString(int time) {
        int hours = time / 60;
        int minutes = time % 60;
        String hoursStr = String.valueOf(hours);
        if (hoursStr.length() == 1) {
            hoursStr = "0" + hoursStr;
        }
        String minutesStr = String.valueOf(minutes);
        if (minutesStr.length() == 1) {
            minutesStr = "0" + minutesStr;
        }
        return hoursStr + ":" + minutesStr;
    }

    private void computeRemainSeat(int humanTime, List<Integer> busTime, List<Integer> remainSeat) {
        for(int i = 0; i < busTime.size(); i++) {
            if(busTime.get(i) < humanTime) {
                continue;
            }
            if (remainSeat.get(i) == 0) {
                continue;
            }
            int setCount = remainSeat.get(i);
            remainSeat.set(i, setCount - 1);
            if (i == busTime.size() - 1) {
                lastBusLastTime = Math.max(lastBusLastTime, humanTime);
            }
            break;
        }
    }
}
