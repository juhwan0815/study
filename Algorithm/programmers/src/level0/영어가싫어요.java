package level0;

public class 영어가싫어요 {

    public static void main(String[] args) {
        solution("onetwothreefourfivesixseveneightnine");
    }

    public static long solution(String numbers) {
        StringBuffer answer = new StringBuffer();
        StringBuffer sb = new StringBuffer();

        String[] numStrArray = new String[] {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };

        int pos = 0;

        char[] chars = numbers.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);

            for(int j = 0; j < numStrArray.length; j++) {
                if(sb.toString().equals(numStrArray[j]))   {
                    answer.append(String.valueOf(j));
                    sb = new StringBuffer();
                }
            }
        }

        return Long.valueOf(answer.toString());
    }

}
