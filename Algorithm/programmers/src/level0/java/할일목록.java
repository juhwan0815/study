
package level0.java;

import java.util.stream.IntStream;

public class 할일목록 {

    public static void main(String[] args) {
        String[] solution = solution(new String[]{
                "problemsolving", "practiceguitar", "swim", "studygraph",
        }, new boolean[]{
                true, false, true, false
        });
        System.out.println(solution);
    }

    public static String[] solution(String[] todo_list, boolean[] finished) {
        return IntStream.range(0, finished.length)
                .filter(value -> !finished[value])
                .mapToObj(value -> todo_list[value])
                .toArray(String[]::new);
    }

}
