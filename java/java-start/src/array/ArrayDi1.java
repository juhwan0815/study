package array;

public class ArrayDi1 {

    public static void main(String[] args) {
        // 2x3 2차원 배열을 만든다.
        int[][] arr = new int[2][3]; // 행2, 열3

        arr[0][0] = 1; // 0행, 0열
        arr[0][1] = 2; // 0행, 1열
        arr[0][2] = 3; // 0행, 2열
        arr[1][0] = 4; // 1행, 0열
        arr[1][1] = 5; // 1행, 1열
        arr[1][2] = 6; // 1행, 2열

        for (int row = 0; row < 2; row++) {
            System.out.print(arr[row][0] + " "); // 0열 출력
            System.out.print(arr[row][1] + " "); // 1열 출력
            System.out.print(arr[row][2] + " "); // 2열 출력
            System.out.println(); // 한 행이 끝나면 라인을 변경Ø한다.
        }
    }
}
