import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

class Solution {
    Map<String, Integer> parkingTime = new HashMap<>();
    Map<String, Integer> totalParkingTime = new TreeMap<>();

    public int[] solution(int[] fees, String[] records) {
        for(String record : records) {
            initParkingTime(fees, record);
        }
        parkingTime.entrySet()
                .stream()
                .filter(es -> es.getValue() != -1)
                .forEach(es -> parkingOut("23:59", es.getKey()));
        return totalParkingTime.entrySet()
                .stream()
                .mapToInt(es -> computeParkingFee(es.getKey(), es.getValue(), fees))
                .toArray();
    }

    private void initParkingTime(int[] fees, String record) {
        String[] parsedRecord = record.split(" ");
        String time = parsedRecord[0];
        String carNum = parsedRecord[1];
        String history = parsedRecord[2];
        if (history.equals("IN")) {
            parkingIn(time, carNum);
            return ;
        }
        parkingOut(time, carNum);
    }

    private void parkingIn(String time, String carNum) {
        int parkingTimeIn = parkingTimeToInt(time);
        parkingTime.put(carNum, parkingTimeIn);
    }

    private void parkingOut(String time, String carNum) {
        int parkingTimeIn = parkingTime.get(carNum);
        int parkingTimeOut = parkingTimeToInt(time);
        int parkingTimeResult = totalParkingTime.getOrDefault(carNum, 0);
        totalParkingTime.put(carNum, parkingTimeResult + parkingTimeOut - parkingTimeIn);
        parkingTime.put(carNum, -1);
    }

    private int parkingTimeToInt(String time) {
        String[] parsedTime = time.split(":");
        int hours = Integer.parseInt(parsedTime[0]);
        int minute = Integer.parseInt(parsedTime[1]);
        return hours * 60 + minute;
    }

    private int computeParkingFee(String carNum, int parkingTime, int[] fees) {
        parkingTime -= fees[0];
        if (parkingTime <= 0) {
            return fees[1];
        }
        return fees[1] + (int)(Math.ceil((double)parkingTime / fees[2])) * fees[3];
    }
}
