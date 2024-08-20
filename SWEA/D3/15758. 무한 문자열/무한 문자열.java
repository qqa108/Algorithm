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
            String a = sc.next();
            String b = sc.next();
            String tmp = "";
            int answer = 1;
            
            if(a.length() < b.length()) {
                tmp = b;
                b = a;
                a = tmp;
            }
            a = a + a;
            
            for(int i=0; i<a.length(); i++) {
                if(a.charAt(i) != b.charAt(i % b.length())) {
                    answer = 0;
                    break;
                }
            }
            if(answer == 1) {
                System.out.println("#" + test_case + " yes");
            }
            else {
                System.out.println("#" + test_case + " no");
            }
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}