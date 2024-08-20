
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = -1;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum = 0;
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}
					if (arr[i] + arr[j] <= M && arr[i] + arr[j] > max) {
						max = arr[i] + arr[j];
					}
				}
			}
			sb.append("#" + test_case + " " + max + "\n");
		}
		System.out.print(sb);
		br.close();
	}
}
