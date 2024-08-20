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
            int arr[] = new int[12];
            int sum = 0;
            int under = 0;
            int over = 0;
            
            for(int i=2; i<=11; i++) {
                arr[i] = 4;
            }
            arr[10] = 16;
            
            for(int i=0; i<n; i++) {
                int a = sc.nextInt();
                sum = sum + a;
                arr[a]--;
            }
            
            
            for(int i=2; i<=11; i++) {
                if(i <= 21 - sum) {
                    under = under + arr[i];
                }
                else {
                    over = over + arr[i];
                }
            }
            if(over >= under) {
                System.out.println("#" + test_case + " STOP");
            }
            else {
                System.out.println("#" + test_case + " GAZUA");
            }
            
            
		}
	}
}