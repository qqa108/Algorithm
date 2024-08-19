import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long pascal[][] = new long[n+1][n+1];

        pascal[0][0] = 0;

        for(int i=1; i<=n; i++) {
            pascal[i][0] = 1;
            for(int j=1; j<i; j++) {
                pascal[i][j] = (pascal[i-1][j-1] + pascal[i-1][j]) % 10007;
            }
            pascal[i][i] = 1;
        }

        System.out.println(pascal[n][k]);

        scanner.close();
    }
}