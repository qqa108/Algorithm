import java.util.*;
//import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T;
		T =10;
		
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int sum = 0;
			int tmp[] = new int[4];
			for(int i=2; i<N-2; i++) {
				int a = 0;
				int b = 0;
				int c = 0;
				if(i < 2) {
					if(i == 0) {
						c = Math.max(arr[i+1], arr[i+2]);
					}
					else {
						b = Math.max(arr[i+1], arr[i+2]);
						c = Math.max(arr[i-1], b);
					}
				}
				else if(i >= N - 2) {
					if(i == N - 2) {
						b = Math.max(arr[i-2], arr[i-1]);
						c = Math.max(arr[i+1], b);
					}
					else {
						c = Math.max(arr[i-2], arr[i-1]);
					}
				}
				else {
					a = Math.max(arr[i-2], arr[i-1]);
					b = Math.max(arr[i+1], arr[i+2]);
					c = Math.max(a, b);
				}
				
				if(c < arr[i]) {
					sum = sum + arr[i] - c;
				}
			}
			System.out.println("#" + test_case + " " + sum);
			
		}
	}
}