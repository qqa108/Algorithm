import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
        int index = 2;
        int arr[] = new int[1000001];
        arr[0] = -1;
        arr[1] = -1;
        
        while(true) {
            if(index > 1000) {
                break;
            }
            for(int i=index+index; i<=1000000; i=i+index) {
                arr[i] = -1;
            }
            for(int i=index+1; i<=1000000; i++) {
                if(arr[i] != -1) {
                    index = i;
                    break;
                }
            }
        }
        
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String s = sc.next();
            int A = sc.nextInt();
            int B = sc.nextInt();
            char D = s.charAt(0);
            int answer = 0;
            
            for(int i=A; i<=B; i++) {
                if(arr[i] == 0) {
                    String num = "";
                    num = num + i;
                    
                    for(int j=0; j<num.length(); j++) {
                        if(num.charAt(j) == D) {
                            answer++;
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + answer);

		}
	}
}