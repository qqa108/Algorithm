import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[45];

        for(int i=1; i<=44; i++) {
            arr[i] = (i*(i+1)) / 2;
        }

        for(int i=0; i<n; i++) {
            int num = scanner.nextInt();
            int answer = 0;

            for(int a=1; a<=44; a++) {
                for(int b=1; b<=44; b++) {
                    for(int c=1; c<=44; c++) {
                        if(arr[a] + arr[b] + arr[c] == num) {
                            answer=1;
                            a=44; b=44; c=44;
                        }
                    }
                }
            }

            if(answer==1) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
        
        scanner.close();
    }
}