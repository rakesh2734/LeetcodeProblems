package recursion;

import java.math.BigInteger;

public class Factorial {
    static BigInteger fact(int num) {
        BigInteger ans = new BigInteger("1");

        for (int i=2; i<= num; i++)   {
            ans = ans.multiply(BigInteger.valueOf(i));
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 10000;
        BigInteger factorialVal = fact(n);
        System.out.println(factorialVal);

        String factorialString;
    }

}