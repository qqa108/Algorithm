import java.util.*;

public class Main {
    static boolean is666(int num) {
        int test[] = new int[7];
        int j=0;
        int count = 0;

        for(int i=1000000; i>=1; i=i/10) {
            test[j] = num/i;

            if(test[j]==6) {
                count++;
                if(count==3) {
                    return true;
                }
            }
            else {
                count=0;
            }
            num = num - (num/i)*i;
            j++;
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[10001];
        int i=1;
        int number=666;
        arr[0]=0;

        while(true) {
            if(is666(number)) {
                arr[i] = number;
                if(i==n) {
                    System.out.println(arr[i]);
                    break;
                }
                i++;
            }
            number++;
        }
        scanner.close();
    }
}