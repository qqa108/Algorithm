import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int dp[] = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        dp[0] = arr[0];
        int max = dp[0];

        for(int i=1; i<n; i++) {
            if(dp[i-1] < 0 && arr[i] > 0) {
                dp[i] = arr[i];
            }
            else if(dp[i-1] < 0 && arr[i] < 0) {
                dp[i] = arr[i];
            }
            else if(dp[i-1] > 0 && arr[i] > 0) {
                dp[i] = dp[i-1] + arr[i];
            }
            else {
                if(dp[i-1] + arr[i] < 0) {
                    dp[i] = arr[i];
                }
                else {
                    dp[i] = dp[i-1] + arr[i];
                }
            }
            //System.out.println(dp[i]);

            if(max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);

        scanner.close();
    }
}