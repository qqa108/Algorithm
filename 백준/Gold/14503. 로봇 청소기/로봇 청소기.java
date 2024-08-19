import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		int di[] = { -1, 0, 1, 0 };
		int dj[] = { 0, 1, 0, -1 };
		st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int dis = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;

		while (true) {
			if (arr[x][y] == 0) {
				arr[x][y] = 2;
				count++;
			}
			else {
				boolean check = false;
				for (int i = 0; i < 4; i++) { // 인접 4곳 중 청소할 칸이 있는지 확
					if (x + di[i] >= 0 && x + di[i] < N && y + dj[i] >= 0 && y + dj[i] < M
							&& arr[x + di[i]][y + dj[i]] == 0) {
						check = true;
						break;
					}
				}
				if (check) { // 청소할 곳이 있으면
					dis = (dis + 3) % 4; // 반시계 90도 회전
					if (x + di[dis] >= 0 && x + di[dis] < N && y + dj[dis] >= 0 && y + dj[dis] < M
							&& arr[x + di[dis]][y + dj[dis]] == 0) { // 앞이 청소가능하면
						x = x + di[dis];
						y = y + dj[dis];
					}
				}
				else { // 청소할 곳이 없으면
					int tmp = (dis + 2) % 4; // 그대로 후진하도록
					if (x + di[tmp] >= 0 && x + di[tmp] < N && y + dj[tmp] >= 0 && y + dj[tmp] < M) {
						if (arr[x + di[tmp]][y + dj[tmp]] == 1) { // 뒤가 벽이면 탈
							break;
						}
						else { // 후진
							x = x + di[tmp];
							y = y + dj[tmp];
						}
					}
				}
			}
		}
		
		System.out.println(count);
	}
}