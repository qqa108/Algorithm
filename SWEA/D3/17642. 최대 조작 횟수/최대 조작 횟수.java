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
            long a = sc.nextLong();
            long b = sc.nextLong();
            long sub = b - a;
            
            if(sub == 0) {
                System.out.println("#" + test_case + " 0");
            }
            else if(sub < 0 || sub == 1) {
                System.out.println("#" + test_case + " -1");
            }
            else {
                System.out.println("#" + test_case + " " + (sub / 2));
            }

		}
	}
}