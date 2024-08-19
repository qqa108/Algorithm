import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        long total = 0;

        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
            total = total + arr[i];
        }
        Arrays.sort(arr);

        long budget = scanner.nextLong();
        long sum = 0;
        long answer = 0;
        long max = 0;

        if(total <= budget) {
            System.out.println(arr[n-1]);
        }
        else {
            for(int i=0; i<n; i++) {
                answer = (budget - sum) / (n-i);
                if(max < answer) {
                    max = answer;
                }
                sum = sum + arr[i];
            }
            System.out.println(max);
        }
        
        scanner.close();
    }
}