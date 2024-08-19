import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        long dp[] = new long[num+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=num; i++) {
            dp[i] = (dp[i-2]*2 + dp[i-1]) % 10007;
        }
        System.out.println(dp[num]);

        scanner.close();
    }
}