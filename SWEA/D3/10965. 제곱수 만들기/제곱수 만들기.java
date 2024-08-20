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
            int root = (int)Math.sqrt(n);
            
            for(int i=root; i>=1; i--) {
                int a = i * i;
                if(n % a == 0) {
                    System.out.print("#" + test_case + " " + (n / a) + "\n");
                    break;
                }
            }
		}
	}
}