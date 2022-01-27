package level1;

public class XXXX년 {

    public static void main(String[] args) {
        solution(12, 31);
    }

    public static String solution(int a, int b) {
        // 요일과 매월 몇일인지 정의
        String[] weekDays = new String[]{"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] monthDays = new int[]{0, 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int sumDays = 0;
        // 월에 따라 일수를 더한다.
        for (int i = 0; i <= a; i++) {
            sumDays += monthDays[i];
        }
        sumDays += b;
        // 일수의 7일로 나눈다.
        int weekDayIndex = sumDays % 7;

        // 나누고 난뒤 -1을 한다.
        return weekDays[weekDayIndex];
    }
}
