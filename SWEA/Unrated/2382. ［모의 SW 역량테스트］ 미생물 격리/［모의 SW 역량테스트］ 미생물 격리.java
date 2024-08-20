import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static int K;
	static List<Virus> list;
	static int delta[];
	static int count;
	static long sum;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 배열크기
			M = Integer.parseInt(st.nextToken()); // 시간
			K = Integer.parseInt(st.nextToken()); // 군집수
			list = new ArrayList<>();
			delta = new int[4];
			delta[0] = -N;
			delta[1] = N;
			delta[2] = -1;
			delta[3] = 1;

			sum = 0;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				list.add(new Virus(x * N + y, num, dir));
				sum = sum + num;
			}
			count = 0;
			bfs();
			sb.append('#').append(test_case).append(' ').append(sum).append('\n');
		}
		System.out.println(sb);
	}

	static class Virus implements Comparable<Virus> {
		int index;
		int num;
		int dir;

		public Virus(int index, int num, int dir) {
			this.index = index;
			this.num = num;
			this.dir = dir;
		}

		@Override
		public int compareTo(Virus o) {
			if (this.index == o.index) {
				return o.num - this.num;
			}
			return this.index - o.index;
		}
	}

	static void bfs() {
		while (!list.isEmpty()) {
			if (count == M || sum <= 0) {
				break;
			}

			int size = list.size();
			for (int s = 0; s < size; s++) {
				Virus now = list.remove(0);
				int next = now.index + delta[now.dir];

				if (next % N == 0 || next % N == N - 1 || next / N == 0 || next / N == N - 1) {
					sum = sum - (now.num - (now.num / 2));
					now.num = now.num / 2;
					if (now.dir % 2 == 0) {
						now.dir = now.dir + 1;
					}
					else {
						now.dir = now.dir - 1;
					}
					if (now.num != 0) {
						list.add(new Virus(next, now.num, now.dir));
					}
				}
				else {
					list.add(new Virus(next, now.num, now.dir));
				}
			}
			Collections.sort(list);
			count++;

			for (int i = 1; i < list.size(); i++) { // 겹치는 바이러스들 제거
				Virus pre = list.get(i - 1);
				Virus now = list.get(i);
				if (pre.index == now.index) {
					pre.num = pre.num + now.num;
					list.remove(i);
					i--;
				}
			}
		}
	}
}