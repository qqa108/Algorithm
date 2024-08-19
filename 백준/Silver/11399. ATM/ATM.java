import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long atm[] =  new long[n];
        long sum = 0;
        long time = 0;

        for(int i=0; i<n; i++) {
            atm[i] = scanner.nextInt();
        }
        Arrays.sort(atm);

        for(int i=0; i<n; i++) {
            sum = sum + atm[i];
            atm[i] = sum;
            time = time + atm[i];
        }

        System.out.println(time);

        scanner.close();
    }
}