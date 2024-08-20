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
            int count = 0;
            
            for(int i=-n; i<=n; i++) {
                for(int j=-n; j<=n; j++) {
                    if(i*i + j*j <= n*n) {
                        count++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + count);
		}
	}
}