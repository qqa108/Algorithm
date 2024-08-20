import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static int K;
	static int arr[][];
	static int answer;
	static int layercount;
	static int[] layer0, layer1;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			layer0 = new int[M];
			layer1 = new int[M];
			Arrays.fill(layer1, 1);

			layercount = 0;
			answer = Integer.MAX_VALUE;
			subset(0);
			sb.append('#').append(test_case).append(' ').append(answer).append('\n');
		}
		System.out.println(sb);
	}

	static void subset(int idx) {
		if (idx == N) {
			int suc = 0;
			for (int i = 0; i < M; i++) {
				int count = 1;
				for (int j = 1; j < N; j++) {
					if (arr[j][i] == arr[j - 1][i]) {
						count++;
					} else {
						count = 1;
					}

					if (count >= K) {
						suc++;
						break;
					}
				}
				if (suc != i + 1) {
					break;
				}
			}
			if (suc == M) {
				answer = Math.min(answer, layercount);
			}

			return;
		}
		int[] tmp = arr[idx];
		subset(idx + 1);

		arr[idx] = layer0;
		layercount++;
		subset(idx + 1);
		layercount--;

		arr[idx] = layer1;
		layercount++;
		subset(idx + 1);
		layercount--;
		arr[idx] = tmp;
	}
}