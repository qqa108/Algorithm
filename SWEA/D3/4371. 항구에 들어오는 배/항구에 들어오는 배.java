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
            ArrayList <Integer> list = new ArrayList<>();
            
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                arr[i]--;
            }
            
            for(int i=1; i<n; i++) {
                int count = 0;
                for(int j=0; j<list.size(); j++) {
                    if(arr[i] % list.get(j) == 0) {
                        count = 1;
                        break;
                    }
                }
                if(count == 0) {
                    list.add(arr[i]);
                }
            }
            
            System.out.println("#" + test_case + " " + list.size());
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}