import java.util.*;

public class Main {
    static int mod = 10007;
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long dp[][] = new long[n+1][11];

        for(int i=1; i<=10; i++) {
            dp[1][i] = i;
        }

        for(int i=2; i<=n; i++) {
            for(int j=1; j<=10; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % mod;
            }
            //System.out.println("*" + dp[i][10]);
        }
        System.out.println(dp[n][10]%mod);

        scanner.close();
    }
}
