import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean visit[];
	static int sum;
	static int answer;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			arr = new int[11][11];

			for (int i = 0; i < 11; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 11; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			visit = new boolean[11];
			sum = 0;
			answer = 0;
			perm(0);
			sb.append(answer).append('\n');
		}
		System.out.println(sb);
	}

	static void perm(int idx) {
		if (idx == 11) {
			answer = Math.max(answer, sum);
			return;
		}
		for (int i = 0; i < 11; i++) {
			if(!visit[i] && arr[idx][i] != 0) {
				visit[i] = true;
				sum = sum + arr[idx][i];
				perm(idx + 1);
				sum = sum - arr[idx][i];
				visit[i] = false;
			}
		}
	}
}