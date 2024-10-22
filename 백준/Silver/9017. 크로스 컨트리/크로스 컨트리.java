import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			List<Integer> arr[] = new ArrayList[201];
			List<Integer> count[] = new ArrayList[201];
			int order[] = new int[N];

			for (int i = 0; i < 201; i++) {
				arr[i] = new ArrayList<>();
				count[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				order[i] = num;
				count[num].add(1);
			}

			int idx = 1;
			for (int i = 0; i < N; i++) {
				if (count[order[i]].size() >= 6) {
					arr[order[i]].add(idx++);
				}
			}

			int min = Integer.MAX_VALUE;
			int minTeam = 0;
			int minFive = 0;

			for (int i = 1; i < arr.length; i++) {
				if (arr[i].size() < 6) {
					continue;
				}
				int sum = 0;
				int five = arr[i].get(4);
				for (int j = 0; j < 4; j++) {
					sum = sum + arr[i].get(j);
				}

				if (sum < min || (sum == min && five < minFive)) {
					min = sum;
					minTeam = i;
					minFive = five;
				}
			}
			sb.append(minTeam).append("\n");

		}
		System.out.println(sb);
	}
}