import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int apple = scanner.nextInt();
        int drop;
        int left = 0;
        int right = m-1;
        int sum = 0;

        for(int i=0; i<apple; i++) {
            drop = scanner.nextInt()-1;

            if(drop<left) {   //왼쪽으로 떨어짐
                sum = sum + (left - drop);
                right = right - (left - drop);
                left = left - (left -drop);
            }
            else if(drop>right) {   //오른쪽으로 떨어짐
                sum = sum + (drop - right);
                left = left + (drop - right);
                right = right + (drop - right);
            }
        }

        System.out.println(sum);
        
        scanner.close();
    }
}