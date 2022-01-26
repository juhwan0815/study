package level1;

public class 최소직사각형 {

    public static void main(String[] args) {
//        solution(new int[][]{
//                {60, 50},
//                {30, 70},
//                {60, 30},
//                {80, 40}});
//
        solution(new int[][]{
                {10, 7},
                {12, 3},
                {8, 15},
                {14, 7},
                {5, 15}});

//        solution(new int[][]{
//                {14, 4},
//                {19, 6},
//                {6, 16},
//                {18, 7},
//                {7, 11}});
    }

    public static int solution(int[][] sizes) {
        int biggestWidth = 0;
        int biggestHeight = 0;

        for (int[] size : sizes) {
            // 가로는 세로가 될수가 있다. 그렇다면 둘을 비교해서 크면 가로로 만들고 작으면 세로로 만든다.
            if (size[0] <= size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }

            // 제일 큰 가로와 비교한 뒤 크면 바꾼다.
            if (biggestWidth < size[0]) {
                biggestWidth = size[0];
            }
            // 제일 큰 세로와 비교한 뒤 크면 바꾼다.
            if (biggestHeight < size[1]) {
                biggestHeight = size[1];
            }
        }

        return biggestWidth * biggestHeight;
    }
}
