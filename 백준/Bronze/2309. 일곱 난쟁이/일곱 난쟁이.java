import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[9];
        int sum = -100;

        for(int i=0; i<9; i++) {
            arr[i] = sc.nextInt();
            sum = sum + arr[i];
        }
        Arrays.sort(arr);

        int left = 0;
        int right = 8;
        
        while(true) {
            if(arr[left] + arr[right] == sum) {
                break;
            }
            else if(arr[left] + arr[right] < sum) {
                left++;
            }
            else {
                right--;
            }
        }
        for(int i=0; i<9; i++) {
            if(i == left || i == right) {

            }
            else {
                System.out.println(arr[i]);
            }
        }
		
		sc.close();
	}
}