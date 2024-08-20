import java.util.*;
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
            String s = "";
            
            for(int i=0; i<n; i++) {
                int a = sc.nextInt();
                s = s + a;
            }
            
            int index = 0;
            while(true) {
                if(!s.contains(Integer.toString(index))) {
                    break;
                }
                index++;
            }
            
            System.out.println("#" + test_case + " " + index);
		}
	}
}