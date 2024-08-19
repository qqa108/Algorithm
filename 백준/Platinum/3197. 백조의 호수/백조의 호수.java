import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char arr[][];
	static boolean visit[][];
	static Queue<Point> ice = new ArrayDeque<>();
	static Queue<Point> swan = new ArrayDeque<>();
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int px1, py1, px2, py2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M];

		int cnt = 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();

			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'L') { // 두 백조를 출발점, 도착점 개념으로 보자
					if (cnt == 1) {
						px1 = i;
						py1 = j;
						cnt++;
					}
					else {
						px2 = i;
						py2 = j;
					}
					arr[i][j] = '.';
					ice.add(new Point(i, j));
				}
				else if (arr[i][j] == '.') {
					ice.add(new Point(i, j));
				}
			}
		}

		swan.add(new Point(px1, py1));
		visit[px1][py1] = true;

		int day = 0;
		while (true) {
			if (move()) { // 움직였을때 도착을 했는가
				break;
			}
			remove_ice();
			day++;
		}
		System.out.println(day);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean move() {
		Queue<Point> tmp = new ArrayDeque<>();

		while (!swan.isEmpty()) {
			Point now = swan.poll();
			if (now.x == px2 && now.y == py2) {
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int nextx = now.x + di[i];
				int nexty = now.y + dj[i];
				if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M && !visit[nextx][nexty]) {
					visit[nextx][nexty] = true;
					if (arr[nextx][nexty] == '.') { // 갈 수 있는 곳은 다 방문하고
						swan.add(new Point(nextx, nexty));
					}
					else if (arr[nextx][nexty] == 'X') { // 일단 못가는 곳이면 tmp에 저장
						tmp.add(new Point(nextx, nexty));
					}
				}
			}
		}
		swan = tmp; // swan다 끝나면 tmp 값들을복사
		return false;
	}

	static void remove_ice() {
		int size = ice.size();
		for (int s = 0; s < size; s++) { // 너비 1만 본다. visit 체크 안해도된다
			Point now = ice.poll();

			for (int i = 0; i < 4; i++) {
				int nextx = now.x + di[i];
				int nexty = now.y + dj[i];
				if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M) {
					if (arr[nextx][nexty] == 'X') { // 표면의 얼음, 녹을예정
						arr[nextx][nexty] = '.';
						ice.add(new Point(nextx, nexty)); // 다음에 깹시다 얼음을
					}
				}
			}
		}
	}
}