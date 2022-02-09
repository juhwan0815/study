package array;

import java.util.*;

public class 임시반장정하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] numArray = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                numArray[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(numArray));
    }

    public static int solution(int[][] numArray) {
        int[] students = new int[numArray.length];

        for (int i = 0; i < numArray.length; i++) {

            Map<Integer, List<Integer>> ban = new HashMap<>();
            for (int j = 0; j < numArray.length; j++) {
                if (ban.containsKey(numArray[j][i])) {
                    List<Integer> studentList = ban.get(numArray[j][i]);
                    studentList.add(j);
                } else {
                    List<Integer> studentList = new ArrayList<>();
                    studentList.add(j);
                    ban.put(numArray[j][i], studentList);
                }
            }

            for (int key : ban.keySet()) {
                List<Integer> studentList = ban.get(key);
                if (studentList.size() >= 2) {
                    for (Integer student : studentList) {
                        students[student]++;
                    }
                }
            }
        }


        return Arrays.stream(students).max().getAsInt() + 1;
    }

}
