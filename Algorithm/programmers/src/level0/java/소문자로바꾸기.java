package level0.java;

import java.util.Scanner;

public class 소문자로바꾸기 {

    public static void main(String[] args) {
        String solution = solution("aBcDeFg");
        System.out.println(solution);
    }

    public static String solution(String myString) {
        return myString.toLowerCase();
    }

}
