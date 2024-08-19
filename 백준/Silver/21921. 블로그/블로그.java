import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int blog[] = new int[n+1];

        int max = 0;
        int count = 0;
        int sum = 0;
        blog[0] = 0;

        for(int i=1; i<=n; i++) {
            blog[i] = scanner.nextInt();
            int left = i-x;
            int right = i;

            if(i >= x) {
                sum = sum - blog[left] + blog[right];
                if(max < sum) {
                    max = sum;
                    count = 1;
                }
                else if(max == sum) {
                    count++;
                }
            }
            else {
                sum = sum + blog[i];
            }
        }
        if(max == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(max);
            System.out.println(count);
        }

        scanner.close();
    }
}