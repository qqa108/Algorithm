import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int getSort(int num) {
        String s = "";
        s = s + num;
        char []arr = s.toCharArray();
        Arrays.sort(arr);
        s = "";
        for(int i=0; i<arr.length; i++) {
            s = s + arr[i];
        }
        num = Integer.parseInt(s);
        return num;
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int sample = getSort(n);
            
            int answer = 0;
            
            for(int i=2; i<10; i++) {
                if(sample == getSort(n * i)) {
                    answer = 1;
                }
            }
            if(answer == 1) {
                System.out.println("#" + test_case + " possible");
            }
            else {
                System.out.println("#" + test_case + " impossible");
            }
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}