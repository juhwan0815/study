package level2;

import java.util.*;

public class 주차요금계산 {

    public static void main(String[] args) {
        solution(new int[]{180, 5000, 10, 600},
                new String[]{
                        "05:34 5961 IN",
                        "06:00 0000 IN",
                        "06:34 0000 OUT",
                        "07:59 5961 OUT",
                        "07:59 0148 IN",
                        "18:59 0000 IN",
                        "19:09 0148 OUT",
                        "22:59 5961 IN",
                        "23:00 5961 OUT"});

        solution(new int[]{120, 0, 60, 591},
                new String[]{
                        "16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"});
    }

    public static int[] solution(int[] fees, String[] records) {
        // 자동차별 주차요금계산
        Map<String, Integer> parkHistoryRepository = new HashMap<>();
        Map<String, Integer> parkTimeRepository = new HashMap<>();
        Map<String, Integer> parkPriceRepository = new HashMap<>();

        // 주차 시간 계산하기
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            String[] timeString = record[0].split(":");

            int time = Integer.parseInt(timeString[0]) * 60 + Integer.parseInt(timeString[1]);

            // 주차기록이 없으면
            if (!parkHistoryRepository.containsKey(record[1])) {
                parkHistoryRepository.put(record[1], time);
            } else { // 주차 기록이 있으면

                // 이전 기록이 있으면 거기에 시간을 추가한다.
                if (parkTimeRepository.containsKey(record[1])) {
                    Integer recordParkTime = parkTimeRepository.get(record[1]);

                    Integer recordedTime = parkHistoryRepository.get(record[1]);
                    parkTimeRepository.put(record[1], time - (int) recordedTime + (int) recordParkTime);

                } else {
                    Integer recordedTime = parkHistoryRepository.get(record[1]); // 주차한 시간
                    parkTimeRepository.put(record[1], time - (int) recordedTime); // 주차시간을 저장
                }
                parkHistoryRepository.remove(record[1]);
            }
        }

        // 주차된 차들을 가지고
        for (String key : parkHistoryRepository.keySet()) {
            int time = 23 * 60 + 59;

            if (parkTimeRepository.containsKey(key)) {
                Integer recordParkTime = parkTimeRepository.get(key);

                Integer recordedTime = parkHistoryRepository.get(key);
                parkTimeRepository.put(key, time - (int) recordedTime + (int) recordParkTime);

            } else {
                Integer recordedTime = parkHistoryRepository.get(key); // 주차한 시간
                parkTimeRepository.put(key, time - (int) recordedTime); // 주차시간을 저장
            }
        }

        for (String key : parkTimeRepository.keySet()) {
            int calTime = parkTimeRepository.get(key) - fees[0];
            if (calTime < 0) {
                parkPriceRepository.put(key, fees[1]);
            } else {
                parkPriceRepository.put(key, (int) (fees[1] + (Math.ceil((double) calTime / fees[2]) * fees[3])));
            }

        }

        Object[] keyArr = parkTimeRepository.keySet().toArray();
        Arrays.sort(keyArr);

        int[] result = new int[keyArr.length];
        for (int i = 0; i < keyArr.length; i++) {
            result[i] = parkPriceRepository.get(keyArr[i]);
        }

        return result;
    }
}
