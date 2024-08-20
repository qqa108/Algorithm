import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int d = sc.nextInt();
            int arr[] = new int[n];
            int count = 0;
            int answer = 0;
            
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                if(arr[i] == 0) {
                    count++;
                }
                else {
                    count = 0;
                }
                if(count == d) {
                    count = 0;
                    answer++;
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}