import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int wheel[][] = new int[T][8]; // 톱니바퀴
		int dre[][] = new int[T][3]; // 톱니바퀴 상좌우 인덱

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < 8; j++) {
				if (s.charAt(j) == '0') {
					wheel[i][j] = 0;
				} else {
					wheel[i][j] = 1;
				}
			}
			dre[i][0] = 0;
			dre[i][1] = 6;
			dre[i][2] = 2;
		}

		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int rotate = Integer.parseInt(st.nextToken());

			int state[] = new int[T]; // 톱니들의 회전해야하는 방향 1, -1, 0
			state[num] = rotate;
			int index = num;

			while (true) { // 왼쪽부터 살펴본다
				if (index == 0 || wheel[index][dre[index][1]] == wheel[index - 1][dre[index - 1][2]]) {
					break;
				} else {
					state[index - 1] = -state[index];
				}
				index--;
			}

			index = num;
			while (true) { // 다음 오른쪽
				if (index == T - 1 || wheel[index][dre[index][2]] == wheel[index + 1][dre[index + 1][1]]) {
					break;
				} else {
					state[index + 1] = -state[index];
				}
				index++;
			}

			for (int j = 0; j < T; j++) { // 상태에 따른 인덱스 변경
				if (state[j] == 1) {
					dre[j][0] = (dre[j][0] + 7) % 8;
					dre[j][1] = (dre[j][1] + 7) % 8;
					dre[j][2] = (dre[j][2] + 7) % 8;
				} else if (state[j] == -1) {
					dre[j][0] = (dre[j][0] + 1) % 8;
					dre[j][1] = (dre[j][1] + 1) % 8;
					dre[j][2] = (dre[j][2] + 1) % 8;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < T; i++) {
			sum = sum + wheel[i][dre[i][0]];
		}
		System.out.println(sum);
	}
}