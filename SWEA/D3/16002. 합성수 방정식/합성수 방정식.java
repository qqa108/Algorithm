import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static boolean isNotPrime(int num) {
        if(num < 2) {
            return false;
        }
        for(int i=2; i<num; i++) {
            if(num % i == 0) {
                return true;
            }
        }
        return false;
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int left = 0;
            int right = n;
            
            while(true) {
                if(isNotPrime(left) && isNotPrime(right)) {
                    System.out.println("#" + test_case + " " + right + " " + left);
                    break;
                }
                else {
                    left++;
                    right++;
                }
            }
		}
	}
}