import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double sum = 0;
        long max = 0;

        for(int i=0; i<n; i++) {
            long drink = scanner.nextLong();
            if(drink > max) {
                max = drink;
            }
            sum = sum + drink;
        }
        sum = (sum - max) / 2 + max;
        System.out.println(sum);
        
        scanner.close();
    }
}