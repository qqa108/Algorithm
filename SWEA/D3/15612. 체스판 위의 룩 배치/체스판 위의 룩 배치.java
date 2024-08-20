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
            int []arr = new int[8];
            int answer = 1;
            
            for(int i=0; i<8; i++) {
                String s = sc.next();
                int count = 0;
                
                for(int j=0; j<8; j++) {
                    if(s.charAt(j) == 'O') {
                        if(count == 1) {
                            answer = 0;
                            break;
                        }
                        count++;
                        arr[j] = 1;
                    }
                }
            }
            for(int i=0; i<8; i++) {
                if(arr[i] != 1) {
                    answer = 0;
                }
            }
            
            if(answer == 1) {
                System.out.println("#" + test_case + " yes");
            }
            else {
                System.out.println("#" + test_case + " no");
            }
            
		}
	}
}