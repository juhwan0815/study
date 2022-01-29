package level1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

    public static void main(String[] args) {
        solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantRepository = new HashMap<>();

        // 참여 저장소에 저장한다.
        for (int i = 0; i < participant.length; i++) {
            Integer count = participantRepository.get(participant[i]);
            if (count == null) {
                participantRepository.put(participant[i], 1);
            } else {
                participantRepository.put(participant[i], count + 1);
            }
        }

        // 참여 저장소에서 제거하거나 횟수를 감소시킨다. 완주를 실패하면 남아있다.
        for (int i = 0; i < completion.length; i++) {
            Integer count = participantRepository.get(completion[i]);
            if(count == 1){
                participantRepository.remove(completion[i]);
            } else {
                count--;
                participantRepository.put(completion[i], count);
            }
        }

        // 남아있는 키를 반환한다.
        String answer = "";
        for (String s : participantRepository.keySet()) {
            answer = s;
            break;
        }

        return answer;
    }
}
