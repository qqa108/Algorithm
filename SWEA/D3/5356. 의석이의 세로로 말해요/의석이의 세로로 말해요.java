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
            char arr[][] = new char[5][15];
            
            for(int i=0; i<5; i++) {
                String s = sc.next();
                for(int j=0; j<s.length(); j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
            
            String answer = "";
            
            for(int i=0; i<15; i++) {
                for(int j=0; j<5; j++) {
                    if(arr[j][i] != '\0') {
                        answer = answer + arr[j][i];
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}