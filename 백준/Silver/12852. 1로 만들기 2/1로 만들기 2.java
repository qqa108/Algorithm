import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dp[] = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i/3] + 1, dp[i]);
            }
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i/2] + 1, dp[i]);
            }
        }
        System.out.println(dp[n]);

        while(true) {
            int tmp;
            System.out.print(n + " ");

            if(n == 1) {
                break;
            }
            dp[n] = dp[n-1] + 1;
            tmp = n-1;
            if(n % 3 == 0) {
                if(dp[n/3] < dp[n]) {
                    tmp = n/3;
                }
                dp[n] = Math.min(dp[n/3] + 1, dp[n]);
            }
            if(n % 2 == 0) {
                if(dp[n/2] < dp[n]) {
                    tmp = n/2;
                }
                dp[n] = Math.min(dp[n/2] + 1, dp[n]);
            }
            n = tmp;

        }

        scanner.close();
    }
}