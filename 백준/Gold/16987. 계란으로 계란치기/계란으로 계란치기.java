import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Egg arr[];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new Egg[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[i] = new Egg(v, w);
		}
		perm(0);
		System.out.println(answer);
	}

	static class Egg {
		int v, w;

		public Egg(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static void perm(int idx) {
		if (idx == N) {
			int count = 0;
			for (int i = 0; i < idx; i++) {
				if (arr[i].v <= 0) {
					count++;
				}
			}
			answer = Math.max(answer, count);
			return;
		}

		boolean check = false;
		for (int i = 0; i < N; i++) {
			if (idx == i || arr[idx].v < 0 || arr[i].v < 0) {
				continue;
			}

			check = true;
			arr[idx].v = arr[idx].v - arr[i].w;
			arr[i].v = arr[i].v - arr[idx].w;
			perm(idx + 1);
			arr[idx].v = arr[idx].v + arr[i].w;
			arr[i].v = arr[i].v + arr[idx].w;
		}
		if (!check) {
			perm(idx + 1);
		}
	}
}