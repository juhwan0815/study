package level0;

public class 가까운수 {

    public static void main(String[] args) {
        solution(new int[]{3,10,28}, 20);
    }

    public static int solution(int[] array, int n) {
        int answer = 0;
        int minDiff = 200;

        for(int num : array) {
            int diff =  Math.abs(num - n);

            if(minDiff > diff) {
                minDiff = diff;
                answer = num;
            } else if(minDiff == diff) {
                if(answer > num) {
                    answer = num;
                }
            }
        }

        return answer;
    }

}
