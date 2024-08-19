import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        long lan[] = new long[k];
        long sum = 0;

        for(int i=0; i<k; i++) {
            lan[i] = scanner.nextLong();
            sum = sum + lan[i];
        }

        long left = 1;
        long right = sum;
        long mid = (left + right) / 2;
        long count = 0;

        while(left <= right) {
            count = 0;

            for(int i=0; i<k; i++) {
                count = count + (lan[i] / mid);
            }

            if(count >=  n) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        System.out.println(mid);

        scanner.close();
    }
}
