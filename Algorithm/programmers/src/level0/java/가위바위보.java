package level0.java;

import java.util.stream.Collectors;

public class 가위바위보 {

    public static void main(String[] args) {
        String solution = solution("205");
        System.out.println(solution);
    }

    public static String solution(String rsp) {
        return rsp.chars()
                .mapToObj(value -> {
                    if((char) value == '2') {
                        return "0";
                    } else if((char) value == '0') {
                        return "5";
                    } else {
                        return "2";
                    }
                })
                .collect(Collectors.joining());
    }

}
