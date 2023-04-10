package level0;

import java.math.BigInteger;

public class 구술을나누는경우의수 {

    public static void main(String[] args) {
        solution(30, 15);
    }

    public static int solution(int balls, int share) {
        // 다시 풀기
        BigInteger n = BigInteger.ONE;
        BigInteger m = BigInteger.ONE;
        BigInteger nm = BigInteger.ONE;

        for(int i = 1; i <= balls; i ++) {
            n = n.multiply(new BigInteger(Integer.toString(i)));
        }

        for(int i = 1; i <= share; i ++) {
            m = m.multiply(new BigInteger(Integer.toString(i)));
        }

        for(int i = 1; i <= balls-share; i ++) {
            nm = nm.multiply(new BigInteger(Integer.toString(i)));
        }

        return n.divide(m.multiply(nm)).intValue();
    }



}
