package level0.java;

public class A강조하기 {

    public static void main(String[] args) {
        String solution = solution("abstract algebra");
        System.out.println(solution);
    }

    public static String solution(String myString) {
        return myString
                .toLowerCase()
                .replaceAll("a","A");
    }

}
