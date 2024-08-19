import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int dp[] = new int[10001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i=4; i<=10000; i++) {
            if(i % 2 == 0) {
                dp[i] = dp[i-1] + ((i / 3) / 2) + 1;
            }
            else {
                dp[i] = dp[i-1] + (((i / 3) - 1) / 2) + 1;
            }
        }

        for(int test=0; test<t; test++) {
            int n = scanner.nextInt();
            System.out.println(dp[n]);
        }
        scanner.close();
    }
}
