import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		int K = sc.nextInt();

		for (int i = 0; i < K; i++) {
			int gender = sc.nextInt();
			int num;

			if (gender == 1) {
				num = sc.nextInt();

				for (int j = num; j <= N; j = j + num) {
					arr[j] = (arr[j] + 1) % 2;
				}
			}
			else {
				num = sc.nextInt();
				int left = num - 1;
				int right = num + 1;

				while (true) {
					if (left < 1 || right > N || arr[left] != arr[right]) {
						left++;
						right--;
						break;
					}
					left--;
					right++;
				}
				for (int j = left; j <= right; j++) {
					arr[j] = (arr[j] + 1) % 2;
				}
			}
		}

		int index = 0;
		while (true) {
			if (index == N) {
				break;
			}
			System.out.print(arr[++index] + " ");
			
			if (index % 20 == 0) {
				System.out.println();
			}
		}
		sc.close();
	}
}