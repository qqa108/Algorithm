import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int coin[] = new int[n];
        int count = 0;

        for(int i=0; i<n; i++) {
            coin[i] = scanner.nextInt();
        }
        for(int i=n-1; i>=0; i--) {
            if(k/coin[i] > 0) {
                count = count + k/coin[i];
                k = k - coin[i] * (k/coin[i]);
            }
        }
        System.out.println(count);

        scanner.close();
    }
}