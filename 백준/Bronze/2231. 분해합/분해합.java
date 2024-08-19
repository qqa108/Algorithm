import java.util.Scanner;

public class Main {
    static int eachcount(int answer) {
        int sum = 0;
        while(true) {
            if(answer==0) {
                break;
            }
            sum = sum + answer % 10;
            answer = (answer - (answer % 10)) / 10;
        }
        return sum;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer=0;

        for(int i=0; i<n; i++) {
            answer=i;
            if(answer + eachcount(answer) == n) {
                break;
            }
        }
        if(answer==n-1) {
            System.out.println(0);
        }
        else {
            System.out.println(answer);
        }
        
        scanner.close();
    }
}