import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int L;
	static int R;
	static Nation arr[][];
	static boolean visit[][];
	static int check[][];
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int sum = 0;
	static int count = 0;
	static int cnt = 0;
	static List<Integer> sumlist = new ArrayList<>();
	static List<Integer> countlist = new ArrayList<>();
	static int index = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new Nation[N][N];
		visit = new boolean[N][N];
		check = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = new Nation(Integer.parseInt(st.nextToken()));
			}
		}

		int day = 0;
		while (true) {
			cnt = 0;
			doOpen(); // 국가 문 개방
			if (cnt == 0) { // 더이상 열 곳이 없으면 종료
				break;
			}
			sumlist.clear();
			countlist.clear();
			visit = new boolean[N][N];
			check = new int[N][N];
			index = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] == false) {
						visit[i][j] = true;
						sum = arr[i][j].popul;
						count = 1;
						check[i][j] = index;
						dfs(i, j); // 처음 방문한 한 점에서 dfs

						sumlist.add(sum);
						countlist.add(count);

						index++;
					}
				}
			}
			MergePopul(); // 개방된 곳들끼리 합병

			doClose(); // 국가 문 닫기
			day++;

//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(arr[i][j].popul + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("--------");
		}

		System.out.println(day);
	}

	static class Nation { // 인구, 동서남북 국가 문
		int popul;
		boolean wall[];

		public Nation(int popul) {
			this.popul = popul;
			wall = new boolean[4];
		}
	}

	static void doOpen() { // 국가 문 열기
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int i = 0; i < 4; i++) {
					if (x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < N) {
						int dif = Math.abs(arr[x + di[i]][y + dj[i]].popul - arr[x][y].popul);
						if (dif >= L && dif <= R) { // 인구수 차이가 범위 내
							cnt++;
							arr[x][y].wall[i] = true; // 벽을 true 로 허물기
						}
					}
				}
			}
		}
	}

	static void doClose() { // 국가 문 초기화
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				arr[x][y].wall = new boolean[4];
			}
		}
	}

	static void MergePopul() { // 직전에 방문했던 곳들이라면 합병
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j].popul = sumlist.get(check[i][j]) / countlist.get(check[i][j]);
			}
		}
	}

	static void dfs(int x, int y) { // 국가 문이 열려있으면 탐색
		for (int i = 0; i < 4; i++) {
			if (x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < N && !visit[x + di[i]][y + dj[i]]
					&& arr[x][y].wall[i]) {
				count++;
				sum = sum + arr[x + di[i]][y + dj[i]].popul;
				visit[x + di[i]][y + dj[i]] = true;
				check[x + di[i]][y + dj[i]] = index;

				dfs(x + di[i], y + dj[i]);
			}
		}
	}
}