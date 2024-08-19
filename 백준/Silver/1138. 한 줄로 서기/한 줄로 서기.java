import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];

        for(int i=0; i<n; i++) {
            int h = scanner.nextInt();
            int index = 0;
            int tmp = 0;

            while(true) {
                if(arr[tmp] == 0) {
                    if(index == h) {
                        arr[tmp] = i + 1;
                        break;
                    }
                    index++;
                }
                tmp++;
            }
        }

        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }
}