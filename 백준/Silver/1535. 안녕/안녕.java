import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int hp[] = new int[n];
        int enjoy[] = new int[n];
        int dp[] = new int[100];

        for(int i=0; i<n; i++) {
            hp[i] = scanner.nextInt();
        }
        for(int i=0; i<n; i++) {
            enjoy[i] = scanner.nextInt();
        }

        for(int i=0; i<100; i++) {
            dp[i] = 0;
        }

        for(int i=0; i<n; i++) {
            for(int j=99; j>=hp[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-hp[i]] + enjoy[i]);
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[99]);

        scanner.close();
    }
}