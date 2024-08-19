import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) { // arr == 1 -> apple
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
		}

		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			if (c.equals("L")) { // x<0 : L, x>0 : R
				list.add(-x);
			} else {
				list.add(x);
			}
		}

		int snake[][] = { { 1, 1 }, { 1, 0 } }; // head, tail
		int di[] = { 0, 1, 0, -1 };
		int dj[] = { 1, 0, -1, 0 };
		int index = 0;
		int answer = 0;
		int apple = 0;
		int head = 2;
		int tail = 2;
		arr[1][1] = 2;

		while (true) {
//
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("----------------");

			answer++;
			if (snake[0][0] + di[index] > 0 && snake[0][0] + di[index] <= N && snake[0][1] + dj[index] > 0
					&& snake[0][1] + dj[index] <= N && arr[snake[0][0] + di[index]][snake[0][1] + dj[index]] <= 2) {

				snake[0][0] = snake[0][0] + di[index];
				snake[0][1] = snake[0][1] + dj[index];
				if (arr[snake[0][0]][snake[0][1]] == 1) {
					apple = 1;
				}
				arr[snake[0][0]][snake[0][1]] = ++head;
			} else {
				break;
			}

			if (apple == 1) {
				apple = 0;
			} else {
				for (int i = 0; i < 4; i++) {
					int nexti = snake[1][0] + di[i];
					int nextj = snake[1][1] + dj[i];

					if (nexti > 0 && nexti <= N && nextj > 0 && nextj <= N && arr[nexti][nextj] == tail) {
						arr[nexti][nextj] = 0;
						snake[1][0] = nexti;
						snake[1][1] = nextj;
						tail++;
						break;
					}
				}
			}

			if (!list.isEmpty() && answer == Math.abs(list.get(0))) {
				if (list.get(0) < 0) { // turn left
					index = (index + 3) % 4;
				} else { // turn right
					index = (index + 1) % 4;
				}
				list.remove(0);
			}
		}

		System.out.println(answer);

		br.close();
	}
}