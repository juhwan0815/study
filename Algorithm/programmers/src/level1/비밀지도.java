package level1;

public class 비밀지도 {

    public static void main(String[] args) {
//        solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10});
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        // n * n 배열을 2개 만든다.
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];

        // 배열안에 있는 숫자로 벽을 만든다. 2번 한다.
        for (int i = 0; i < arr1.length; i++) {
            String numStr1 = Integer.toBinaryString(arr1[i]);
            String numStr2 = Integer.toBinaryString(arr2[i]);

            char[] charArray1 = numStr1.toCharArray();
            char[] charArray2 = numStr2.toCharArray();

            // 공백 이후에 배열을 추가한다.
            for (int j = 0; j < charArray1.length; j++) {
                map1[i][n - charArray1.length + j] = Integer.parseInt(String.valueOf(charArray1[j]));
            }

            for (int j = 0; j < charArray2.length; j++) {
                map2[i][n - charArray2.length + j] = Integer.parseInt(String.valueOf(charArray2[j]));
            }
        }

        // 2개의 2차원배열을 비교해서 벽을 찾아낸다.
        char[][] charArray = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map1[i][j] == 1 || map2[i][j] == 1) {
                    charArray[i][j] = '#';
                }
            }
        }

        // 문자 이차원 배열을 돌면서 문자열 배열로 변경한다.
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (charArray[i][j] == '#') {
                    stringBuilder.append("#");
                } else {
                    stringBuilder.append(" ");
                }
            }
            answer[i] = stringBuilder.toString();
        }

        return answer;
    }
}
