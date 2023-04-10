package level0;

public class 삼각형의완성조건2 {

    public static void main(String[] args) {
        solution(new int[]{1, 2});
    }

    public static int solution(int[] sides) {
        int answer = 0;

        // 첫번째 배열안에 있는 변의 길이가 제일 큰경우
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);

        for(int i = 1; i <= max; i++) {
            if(max < (min + i)) {
                answer++;
            }
        }

        // 나머지 변의 길이가 제일 큰 경우
        for(int i = (max + 1); i < (max + min); i++) {
            answer++;
        }

        return answer;
    }

}
