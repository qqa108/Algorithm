import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger mod = new BigInteger("1000000000");
        BigInteger dp[] = new BigInteger[n+1];
        BigInteger sub[] = new BigInteger[10];

        for(int i=0; i<10; i++) {
            sub[i] = new BigInteger("0");
        }
        
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("9");
        if(n > 1) {
            dp[2] = new BigInteger("17");
        }
        
        sub[1] = new BigInteger("1");

        for(int i=3; i<=n; i++) {
            BigInteger sum = BigInteger.ZERO;

            if(i % 2 != 0) {
                for(int j=0; j<10; j=j+2) {
                    if(j >= 2) {
                        sub[j] = sub[j-1].add(sub[j+1]);
                    }
                    else {
                        sub[j] = sub[j+1];
                    }
                    sum = sum.add(sub[j]);
                }
            }
            else {
                for(int j=1; j<10; j=j+2) {
                    if(j < 9) {
                        sub[j] = sub[j-1].add(sub[j+1]);
                    }
                    else {
                        sub[j] = sub[j-1];
                    }
                    sum = sum.add(sub[j]);
                }
            }
            //System.out.println("^" + i + " = " + sum);
            dp[i] = (dp[i-1].multiply(new BigInteger("2")).subtract(sum)).mod(mod);
            //System.out.println("*" + i + " = " + dp[i]);
        }
        System.out.println(dp[n].mod(mod));

        scanner.close();
    }
}
