package level0;

public class 가장큰수찾기 {

    public static void main(String[] args) {
        solution(new int[]{1, 8, 3});
    }

    public static int[] solution(int[] array) {
        int[] answer = new int[2];

        int max = 0;
        int pos = 0;

        for(int i = 0; i < array.length; i++) {
            if(max < array[i]) {
                max = array[i];
                pos = i;
            }
        }

        answer[0] = max;
        answer[1] = pos;

        return answer;
    }

}
