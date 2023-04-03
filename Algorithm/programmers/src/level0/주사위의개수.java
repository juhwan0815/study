package level0;

public class 주사위의개수 {

    public static void main(String[] args) {
        solution(new int[] {10, 8, 6}, 3);
    }

    public static int solution(int[] box, int n) {
        int answer = 0;
        int[] numArray = new int[box.length];

        for(int i = 0; i < box.length; i++) {
            numArray[i] = box[i] / n;
        }

        for(int i = 0; i < numArray.length; i++) {
            if(answer == 0) {
                answer = numArray[i];
            } else {
                answer = answer * numArray[i];
            }
        }

        return answer;
    }

}
