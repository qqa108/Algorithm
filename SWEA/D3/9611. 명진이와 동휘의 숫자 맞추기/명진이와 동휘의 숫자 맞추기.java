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
            int arr[] = new int[10];
            int num[] = new int[4];
            
            for(int i=0; i<n; i++) {
                for(int j=0; j<4; j++) {
                    num[j] = sc.nextInt();
                }
                String s = sc.next();
                
                if(s.equals("YES")) {
                    for(int j=0; j<4; j++) {
                        if(arr[num[j]] != -1) {
                            arr[num[j]]++;
                        }
                    }
                }
                else {
                    for(int j=0; j<4; j++) {
                        arr[num[j]] = -1;
                    }
                }
            }
            
            int max = 0;
            for(int i=0; i<10; i++) {
                if(arr[max] < arr[i]) {
                    max = i;
                }
            }
            System.out.println("#" + test_case + " " + max);
		}
	}
}