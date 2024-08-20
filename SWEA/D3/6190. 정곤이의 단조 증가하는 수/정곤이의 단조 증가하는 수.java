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
            int arr[] = new int[n];
            int answer[] = new int[(n*(n-1))/2];
            
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            
            int index = 0;
            for(int i=0; i<n; i++) {
                for(int j=i+1; j<n; j++) {
                    answer[index++] = arr[i] * arr[j];
                }
            }
            
            Arrays.sort(answer);
            int count = 1;
            String gg = "";
            
            for(int i=answer.length-1; i>=0; i--) {
                String s = "";
                s = s + answer[i];
                count = 1;
                
                for(int j=1; j<s.length(); j++) {
                    if(s.charAt(j-1) > s.charAt(j)) {
                        count = 0;
                        break;
                    }
                }
                if(count == 1) {
                    gg = s;
                    break;
                }
            }
            if(count == 1) {
                System.out.println("#" + test_case + " " + gg);
            }
            else {
                System.out.println("#" + test_case + " -1");
            }
            
		}
	}
}