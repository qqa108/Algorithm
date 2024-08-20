import java.util.Scanner;
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
            int n = sc.nextInt();
            int arr[][] = new int[100][100];
            
            for(int i=0; i<100; i++) {
                for(int j=0; j<100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            int sum = 0;
            int max = 0;
            
            for(int i=0; i<100; i++) {
                sum = 0;
                for(int j=0; j<100; j++) {
                    sum = sum + arr[i][j];
                }
                if(max < sum) {
                    max = sum;
                }
            }
            for(int i=0; i<100; i++) {
                sum = 0;
                for(int j=0; j<100; j++) {
                    sum = sum + arr[j][i];
                }
                if(max < sum) {
                    max = sum;
                }
            }
            
            sum = 0;
            for(int i=0; i<100; i++) {
                sum = sum + arr[i][i];
            }
            if(max < sum) {
                max = sum;
            }
            
            sum = 0;
            for(int i=0; i<100; i++) {
                sum = sum + arr[i][99-i];
            }
            if(max < sum) {
                max = sum;
            }
            
            System.out.println("#" + test_case + " " + max);
		}
	}
}