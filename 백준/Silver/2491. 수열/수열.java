import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int pre = arr[0];
		int bigcount = 1;
		int smallcount = 1;
		int max = 1;
		for (int i = 1; i < N; i++) {
			if (pre <= arr[i]) {
				bigcount++;
			}
			else {
				bigcount = 1;
			}
			if (max < bigcount) {
				max = bigcount;
			}

			if (pre >= arr[i]) {
				smallcount++;
			}
			else {
				smallcount = 1;
			}
			if (max < smallcount) {
				max = smallcount;
			}

			pre = arr[i];
		}
		System.out.println(max);
		sc.close();
	}
}