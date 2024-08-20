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
            int m = sc.nextInt();
            int pee[] = new int[n];
            int weight[] = new int[m];
            int parking[] = new int[n];
            Queue <Integer> queue = new LinkedList<>();
            
            for(int i=0; i<n; i++) {
                pee[i] = sc.nextInt();
            }
            for(int i=0; i<m; i++) {
                weight[i] = sc.nextInt();
            }
            
            int count = 0;
            for(int i=0; i<2*m; i++) {
                int car = sc.nextInt();
                int index = n;
                
                if(car > 0) {
                    for(int j=0; j<n; j++) {
                        if(parking[j] == 0) {
                            index = j;
                            break;
                        }
                    }
                    if(index == n) {
                        //waiting
                        queue.add(car);
                    }
                    else {
                        parking[index] = car;
                    }
                }
                else {
                    car = car * (-1);
                    for(int j=0; j<n; j++) {
                        if(parking[j] == car) {
                            parking[j] = 0;
                            count = count + pee[j] * weight[car-1];
                            if(!queue.isEmpty()) {
                                parking[j] = queue.remove();
                            }
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + count);
		}
	}
}