package level0.java;

public class 첫번째로나오는음수 {

    public static void main(String[] args) {
        int solution = solution(new int[]{12, 4, 15, 46, 38, -2, 15});
        System.out.println(solution);
    }

    public static int solution(int[] num_list) {

        for(int i = 0; i < num_list.length; i++) {
            if(num_list[i] < 0) {
                return i;
            }
        }

        return -1;
    }
}
