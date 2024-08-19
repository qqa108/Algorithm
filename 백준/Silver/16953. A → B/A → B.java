import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        int count = 1;

        while(true) {
            if(b == a) {
                System.out.println(count);
                break;
            }
            else if(b < a) {
                System.out.println("-1");
                break;
            }
            else if(b % 10 == 1) {
                b = b / 10;
                count++;
            }
            else if(b % 2 == 0) {
                b = b / 2;
                count++;
            }
            else if(b % 2 != 0) {
                System.out.println("-1");
                break;
            }
        }
        
        scanner.close();
    }
}