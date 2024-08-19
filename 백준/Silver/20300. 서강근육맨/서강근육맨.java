import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long routine[] = new long[n];

        for(int i=0; i<n; i++) {
            routine[i] = scanner.nextLong();
        }

        Arrays.sort(routine);

        long max = 0;
        
        if(n%2 == 0) {
            max = 0;
            for(int i=0; i<n/2; i++) {
                if((routine[i] + routine[n-1-i]) > max) {
                    max = routine[i] + routine[n-1-i];
                }
            }
        }
        else {
            max = routine[n-1];
            for(int i=0; i<(n-1)/2; i++) {
                if((routine[i] + routine[n-2-i]) > max) {
                    max = routine[i] + routine[n-2-i];
                }
            }
        }
        System.out.println(max);

        scanner.close();
    }
}