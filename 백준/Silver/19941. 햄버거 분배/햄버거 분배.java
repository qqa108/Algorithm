import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        char table[] = new char[n];

        String s = scanner.next();
        for(int i=0; i<n; i++) {
            table[i] = s.charAt(i);
        }

        int count = 0;
        for(int i=0; i<n; i++) {
            if(table[i] == 'P') {
                int min = i-k;
                if(i-k < 0) {
                    min = 0;
                }
                int max = i+k;
                if(i+k > n-1) {
                    max = n-1;
                }

                for(int j=min; j<=max; j++) {
                    if(table[j] == 'H') {
                        count++;
                        table[j] = 'h';
                        break;
                    }
                }
            }
        }
        System.out.println(count);

        scanner.close();
    }
}