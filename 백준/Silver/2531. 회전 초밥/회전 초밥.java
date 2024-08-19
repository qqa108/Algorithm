import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int k = scanner.nextInt();
        int c = scanner.nextInt();
        int table[] = new int[n+k];
        //int sushi[] = new int[d+2];
        int coupon = 0;

        for(int i=0; i<n; i++) {
            table[i] = scanner.nextInt();
        }
        for(int i=n; i<n+k; i++) {
            table[i] = table[i-n];
        }

        int count = 0;
        int max = 0;

        for(int i=0; i<n; i++) {
            int sushi[] = new int[d+2];
            count = 0;
            coupon = 0;

            for(int j=i; j<i+k; j++) {
                if(sushi[table[j]] == 0) {
                    if(table[j] == c) {
                        coupon++;
                    }
                    sushi[table[j]]++;
                    count++;
                }
            }
            if(coupon == 0) {
                count++;
            }
            //System.out.println("^" + count);
            if(max < count) {
                max = count;
            }
        }
        System.out.println(max);

        scanner.close();
    }
}
