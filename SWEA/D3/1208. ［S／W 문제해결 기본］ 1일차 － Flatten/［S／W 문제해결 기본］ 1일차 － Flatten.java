import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int arr[] = new int[100];
            
            for(int i=0; i<100; i++) {
                arr[i] = sc.nextInt();
            }Arrays.sort(arr);
            for(int i=0; i<N; i++) {
                
                arr[99]--;
                arr[0]++;
                
                Arrays.sort(arr);
                if(arr[99] - arr[0] <= 1) {
                    break;
                }
                
            }
            System.out.println("#" + test_case + " " + (arr[99] - arr[0]));
		}
	}
}