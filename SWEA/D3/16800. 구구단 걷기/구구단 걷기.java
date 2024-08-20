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
            long n = sc.nextLong();
            double half = Math.sqrt(n);
            int mid = (int)half;
            
            for(int i=mid; i>0; i--) {
                if(n % i == 0) {
                    System.out.println("#" + test_case + " " + (i + (n / i) - 2));
                    break;
                }
            }

		}
	}
}