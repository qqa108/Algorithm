import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for(int k=0; k<t; k++) {
            int n = scanner.nextInt();
            int arr[][] = new int[2][n];
            int dp[][] = new int[2][n];

            for(int i=0; i<2; i++) {
                for(int j=0; j<n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            int max = Math.max(dp[0][0], dp[1][0]);

            for(int i=1; i<n; i++) {
                if(i - 2 >= 0) {
                    dp[0][i] = arr[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
                    dp[1][i] = arr[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
                }
                else {
                    dp[0][i] = arr[0][i] + dp[1][0];
                    dp[1][i] = arr[1][i] + dp[0][0];
                }

                if(max < Math.max(dp[0][i], dp[1][i])) {
                    max = Math.max(dp[0][i], dp[1][i]);
                }
                //System.out.println(dp[0][i] + " " + dp[1][i]);
            }
            System.out.println(max);
        }
        scanner.close();
    }
}