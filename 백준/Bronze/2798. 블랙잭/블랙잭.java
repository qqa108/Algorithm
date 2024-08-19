import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int card[] = new int[N];

		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		Arrays.sort(card);
		int max = 0;
		
		for(int i=1; i<N-1; i++) {
			int left = 0;
			int right = N - 1;
			
			
			if(max == M) {
				break;
			}
			
			while(true) {
				if(left >= right) {
					break;
				}
				if(left == i) {
					left++;
					continue;
				}
				if(right == i) {
					right--;
					continue;
				}
				
				int sum = card[left] + card[right] + card[i];
				
				if(sum > max && sum <= M) {
					max = sum;
				}
				
				if(sum < M) {
					left++;
				}
				else if(sum > M) {
					right--;
				}
				else {
					max = sum;
					break;
				}
			}
			
		}

		System.out.println(max);
	}
}