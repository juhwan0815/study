package level0.java;

import java.util.stream.Collectors;

public class l로만들기 {

    public static void main(String[] args) {
        String solution = solution("abcdevwxyz");
        System.out.println(solution);
    }

    public static String solution(String myString) {
        return myString.chars()
                .mapToObj(value -> {
                    if(value < (int) 'l'){
                        return "l";
                    } else {
                        return String.valueOf((char) value);
                    }
                })
                .collect(Collectors.joining());
    }

}
