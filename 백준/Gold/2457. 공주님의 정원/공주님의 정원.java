import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int month[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int sigma[] = new int[12]; // 날짜 누적합
	static List<Project> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		sigma[0] = 0;
		for (int i = 1; i < 12; i++) { // 날짜 누적합 구하기
			sigma[i] = sigma[i - 1] + month[i - 1];
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m1 = Integer.parseInt(st.nextToken()) - 1;
			int d1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken()) - 1;
			int d2 = Integer.parseInt(st.nextToken());
			int start = sigma[m1] + d1;
			int end = sigma[m2] + d2;
			list.add(new Project(start, end));
		}
		Collections.sort(list);

		int start = 60;
		int end = 0;
		int count = 0;
		int index = 0;

		while (true) {
			if (start >= 335) {
				break;
			}

			boolean check = false;

			for (int i = index; i < list.size(); i++) {
				if (list.get(i).start > start) {
					break;
				}
				if (list.get(i).start <= start && end < list.get(i).end) {
					end = list.get(i).end;
					index = i + 1;
					check = true;
				}
			}

			if (check) {
				start = end;
				count++;
			}
			else {
				break;
			}
		}
		if (end < 335) {
			count = 0;
		}
		System.out.println(count);
	}

	static class Project implements Comparable<Project> {
		int start;
		int end;

		public Project(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Project o) {
			if (this.start == o.start) {
				return o.end - this.end;
			}
			return this.start - o.start;
		}
	}
}