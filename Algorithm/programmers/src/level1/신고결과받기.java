package level1;

import java.util.*;

public class 신고결과받기 {

    public static void main(String[] args) {

//        String[] idList = {"muzi", "apeach", "frodo", "neo"};
//        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
//        int k = 2;

        String[] idList = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        int[] solution = new Solution().solution(idList, report, k);
    }

    static class Solution {
        /**
         * @param idList 이용자 ID가 담긴 문자열 배열
         * @param report 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열
         * @param k      정지 기준이 되는 신고 회수
         * @return 각 유저별로 처리 결과 메일을 받은 회수
         */
        public int[] solution(String[] idList, String[] report, int k) {
            // 결과 메일 수
            int[] answer = new int[idList.length];

            // 신고 내역 저장소
            Map<String, List<String>> reportRepository = new HashMap<>();

            // 신고  저장소
            Map<String, Integer> reportCountRepository = new HashMap<>();

            // 메일 횟수 저장소
            Map<String, Integer> mailCount = new HashMap<>();

            //  신고한 유저가 신고한 ID를 넣는다.
            for (String reportElement : report) {
                report(reportRepository, reportCountRepository, reportElement);
            }
            suspend(reportRepository, reportCountRepository, mailCount, k);

            for (int i = 0; i < idList.length; i++) {
                String userId = idList[i];
                if (mailCount.containsKey(userId)) {
                    answer[i] = mailCount.get(userId);
                } else {
                    answer[i] = 0;
                }
            }

            return answer;
        }

        private static void suspend(Map<String, List<String>> reportRepository, Map<String, Integer> reportCountRepository, Map<String, Integer> mailCount, int k) {
            Set<String> reportUserIds = reportCountRepository.keySet();
            for (String reportUserId : reportUserIds) {
                if (reportCountRepository.get(reportUserId) >= k) {
                    sendMail(reportRepository, mailCount, reportUserId);
                }
            }
        }

        private static void sendMail(Map<String, List<String>> reportRepository, Map<String, Integer> mailCount, String reportUserId) {
            // 회원의 신고내역과 정지 회수를 비교하여 answer 를 만든다.
            Set<String> userIds = reportRepository.keySet();
            for (String userId : userIds) {
                if (reportRepository.get(userId).contains(reportUserId)) {
                    if (mailCount.containsKey(userId)) {
                        mailCount.put(userId, mailCount.get(userId) + 1);
                        continue;
                    }
                    mailCount.put(userId, 1);
                }
            }
        }

        private static void report(Map<String, List<String>> reportRepository, Map<String, Integer> reportCountRepository, String reportElement) {
            String userId = reportElement.substring(0, reportElement.indexOf(" "));
            String reportUserId = reportElement.substring(reportElement.indexOf(" "));

            List<String> reportUserIdList = reportRepository.get(userId);
            if (reportUserIdList == null) {
                reportUserIdList = new ArrayList<>();
                reportRepository.put(userId, reportUserIdList);
            }

            if (!reportUserIdList.contains(reportUserId)) {
                reportUserIdList.add(reportUserId);
                if (reportCountRepository.containsKey(reportUserId)) {
                    reportCountRepository.put(reportUserId, reportCountRepository.get(reportUserId) + 1);
                } else {
                    reportCountRepository.put(reportUserId, 1);
                }
            }
        }
    }
}