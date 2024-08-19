import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=0; i<n; i++) {
            long num = scanner.nextLong();
            long count = 0;

            while(true) {
                if(num < 5) {
                    break;
                }
                num  = num / 5;
                count = count + num;
            }
            System.out.println(count);
        }

        scanner.close();
    }
}