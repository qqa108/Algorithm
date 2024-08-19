import java.util.*;

public class Main {
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int num[] = new int[n];

        for(int i=0; i<n; i++) {
            num[i] = scanner.nextInt();
        }
        Arrays.sort(num);

        int min = 0;
        int max = n-1;
        int count = 0;

        while(true) {
            if(min >= max) {
                break;
            }
            if((num[min] + num[max]) > m) {
                max--;
            }
            else if((num[min] + num[max]) < m) {
                min++;
            }
            else {
                count++;
                min++;
                max--;
            }
        }
        System.out.println(count);

        scanner.close();
    }
}