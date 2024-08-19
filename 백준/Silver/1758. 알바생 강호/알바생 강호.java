import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int tip[] =  new int[n];
        long sum = 0;

        for(int i=0; i<n; i++) {
            tip[i] = -scanner.nextInt();
        }
        Arrays.sort(tip);
        for(int i=0; i<n; i++) {
            tip[i] = tip[i]*(-1);
            if((tip[i] - i) > 0) {
                sum = sum + tip[i] - i;
            }
        }

        System.out.println(sum);

        scanner.close();
    }
}