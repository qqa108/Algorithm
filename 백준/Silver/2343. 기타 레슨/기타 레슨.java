import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int video[] = new int[n];
        int sum = 0;
        int max = 0;

        for(int i=0; i<n; i++) {
            video[i] = scanner.nextInt();
            sum = sum + video[i];
            if(max < video[i]) {
                max = video[i];
            }
        }

        int left = max;
        int right = sum;
        int mid = (left + right) / 2;
        int count = 0;

        while(left <= right) {
            mid = (left + right) / 2;
            sum = 0;
            count = 1;

            for(int i=0; i<n; i++) {
                if(sum + video[i] > mid) {
                    sum = video[i];
                    count++;
                }
                else {
                    sum = sum + video[i];
                }
            }

            if(count <= m) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(left);

        scanner.close();
    }
}