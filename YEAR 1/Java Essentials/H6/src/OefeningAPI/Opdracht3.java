package OefeningAPI;

import java.math.BigInteger;

public class Opdracht3 {
    public static void main(String[] args) {
        // fac = 1 // voor als je while loop wilt gebruiken.
        int waarde = 21;
        BigInteger result = BigInteger.ONE;
//        while (fac <= waarde) {
//            fac++;
//            result *= fac;
//        }
        for (int i = 2; i <= waarde; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }
}
