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
            String s = sc.next();
            char arr[] = s.toCharArray();
            String answer = "";
            Arrays.sort(arr);
            Queue <Character> queue = new LinkedList <>();
            
            for(int i=0; i<arr.length; i++) {
                if(queue.isEmpty()) {
                    queue.add(arr[i]);
                }
                else {
                    if(arr[i] == queue.peek()) {
                        queue.remove();
                    }
                    else {
                        answer = answer + queue.remove();
                        queue.add(arr[i]);
                    }
                }
            }
            while(true) {
                if(queue.isEmpty()) {
                    break;
                }
                answer = answer + queue.remove();
            }
            
            if(answer.equals("")) {
                System.out.println("#" + test_case + " Good");
            }
            else {
                System.out.println("#" + test_case + " " + answer);
            }
        }
	}
}