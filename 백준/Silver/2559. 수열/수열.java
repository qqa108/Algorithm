import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int temperate[] = new int[n+1];

        int max = -10000001;
        int sum = 0;
        temperate[0] = 0;

        for(int i=1; i<=n; i++) {
            temperate[i] = scanner.nextInt();
            int left = i-x;
            int right = i;

            if(i >= x) {
                sum = sum - temperate[left] + temperate[right];
                if(max < sum) {
                    max = sum;
                }
            }
            else {
                sum = sum + temperate[i];
            }
        }
        System.out.println(max);

        scanner.close();
    }
}