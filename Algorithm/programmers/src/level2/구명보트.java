package level2;

import java.util.*;

public class 구명보트 {

    public static void main(String[] args) {
        solution(new int[]{70, 50, 80, 50}, 100);
//        solution(new int[]{70, 50, 80}, 100);
//        solution(new int[]{40, 40, 40}, 100);
    }

    public static int solution(int[] people, int limit) {

        int answer = 0;
        Arrays.sort(people);

        List<Integer> peopleList = new LinkedList<>();
        for (int person : people) {
            peopleList.add(person);
        }


        while (peopleList.size() > 0) {
            Integer lastPerson = peopleList.remove(peopleList.size() - 1);

            if (!peopleList.isEmpty() && lastPerson + peopleList.get(0) <= limit) {
                peopleList.remove(0);
            }
            answer++;
        }

        return answer;
    }
}
