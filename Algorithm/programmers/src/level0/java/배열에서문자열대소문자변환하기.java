package level0.java;

public class 배열에서문자열대소문자변환하기 {

    public static void main(String[] args) {
        String[] solution = solution(new String[]{"AAA","BBB","CCC","DDD"});
        System.out.println(solution);
    }

    public static String[] solution(String[] strArr) {
        for(int i = 0; i < strArr.length; i++) {
            if(i % 2 == 0) {
                strArr[i] = strArr[i].toLowerCase();
            } else {
                strArr[i] = strArr[i].toUpperCase();
            }
        }
        return strArr;
    }

}
