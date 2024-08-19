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
            if(arr[i-1] >= arr[i]) {
                dp[i] = arr[i];

                for(int j=i-1; j>=0; j--) {
                    if(arr[j] < arr[i] && dp[j] > dp[i] - arr[i]) {
                        dp[i] = dp[j] + arr[i];
                    }
                }
            }
            else {
                dp[i] = dp[i-1] + arr[i];

                for(int j=i-1; j>=0; j--) {
                    if(arr[j] < arr[i] && dp[j] > dp[i] - arr[i]) {
                        dp[i] = dp[j] + arr[i];
                    }
                }
            }
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);

        scanner.close();
    }
}