import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int money[] = new int[n];
        int max = 0;
        long sum = 0;

        for(int i=0; i<n; i++) {
            money[i] = scanner.nextInt();
            sum = sum + money[i];
            if(max < money[i]) {
                max = money[i];
            }
        }

        long left = max;
        long right = sum;
        long mid = (right + left) / 2;

        while(true) {
            if(left > right) {
                break;
            }
            mid = (left + right) / 2;
            int count = 1;
            long remain = mid;

            for(int i=0; i<n; i++) {
                if(remain < money[i]) {
                    count++;
                    remain = mid;
                }
                remain = remain - money[i];
            }
            if(count <= m) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(mid);

        scanner.close();
    }
}
