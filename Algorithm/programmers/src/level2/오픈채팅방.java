package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {

    public static void main(String[] args) {
        solution(new String[]{
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"});
    }

    public static String[] solution(String[] record) {
        // 닉네임이 들어왓다
        // 닉네임이 나갓다
        // 닉네임 변경 새로운 닉네임 들어가기, 채팅방에서 닉네임 변경
        // 기존 채팅방에 출력되어 있던 닉네임 전부 변경
        Map<String, String> memberRepository = new HashMap<>();
        List<String> messageRepository = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] content = record[i].split(" ");

            if (content[0].equals("Enter")) {
                memberRepository.put(content[1], content[2]);
                messageRepository.add(content[1] + "님이 들어왔습니다.");
            } else if (content[0].equals("Leave")) {
                messageRepository.add(content[1] + "님이 나갔습니다.");
            } else {
                memberRepository.put(content[1], content[2]);
            }
        }

        String[] answer = new String[messageRepository.size()];
        for (int i = 0; i < messageRepository.size(); i++) {
            String message = messageRepository.get(i);
            int index = message.indexOf('님');

            String id = message.substring(0, index);
            String content = message.substring(index);

            String nickName = memberRepository.get(id);

            answer[i] = nickName + content;
        }


        return answer;
    }
}
