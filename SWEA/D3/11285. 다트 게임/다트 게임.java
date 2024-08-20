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
            long sum = 0;
            
            for(int i=0; i<n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                double r = Math.sqrt(x*x + y*y);
                
                if(r == 0) {
                    sum = sum + 10;
                }
                if(r <= 200 && r != 0) {
                    sum = sum + (int)(11 - (r / 20));
                }
            }
            System.out.println("#" + test_case + " " + sum);
		}
        
        sc.close();
	}
}