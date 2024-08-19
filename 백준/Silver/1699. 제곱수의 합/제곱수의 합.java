import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dp[] = new int[n+1];
        int index = 1;

        dp[0] = 0;
        for(int i=1; i<=n; i++) {
            if(i == index * index) {
                dp[i] = 1;
                index++;
            }
            else {
                int a = dp[(index-1) * (index-1)] + dp[i - ((index-1) * (index-1))];
                dp[i] = a;
                
                if(index > 2) {
                    int min = a;
                    for(int j=2; j<index-1; j++) {
                        int c = dp[(index-j) * (index-j)] + dp[i - ((index-j)) * (index-j)];
                        if(min > c) {
                            min = c;
                        }
                    }
                    dp[i] = min;
                }
                
            }
        }
        System.out.println(dp[n]);

        scanner.close();
    }
}