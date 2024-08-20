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
            int k = sc.nextInt();
            int n = 1;
            for(int i=0; i<k; i++) {
                n = n * 2;
            }
            Queue <Integer> queue = new LinkedList<>();
            
            for(int i=0; i<n; i++) {
                int a = sc.nextInt();
                queue.add(a);
            }
            
            int count = 0;
            while(true) {
                int a = queue.remove();
                if(queue.isEmpty()) {
                    break;
                }
                int b = queue.remove();
                
                if(a >= b) {
                    count = count + a - b;
                    queue.add(a);
                }
                else {
                    count = count + b - a;
                    queue.add(b);
                }
            }
            System.out.println("#" + test_case + " " + count);
		}
	}
}