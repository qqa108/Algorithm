import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int milk[] =  new int[n];
        long sum = 0;

        for(int i=0; i<n; i++) {
            milk[i] = -scanner.nextInt();
        }
        Arrays.sort(milk);
        for(int i=0; i<n; i++) {
            milk[i] = milk[i]*(-1);
            if((i+1) % 3 != 0) {
                sum = sum + milk[i];
            }
        }

        System.out.println(sum);

        scanner.close();
    }
}