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
		int K = Integer.parseInt(st.nextToken());
		List<Boolean> robot = new ArrayList<>();
		List<Integer> belt = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			int num = Integer.parseInt(st.nextToken());
			belt.add(num);
			robot.add(false);
		}

		int in = 0;
		int out = N - 1;
		int end = (2 * N) - 1;
		int zero = 0;
		int count = 0;

		while (true) {
			if (zero >= K) {
				break;
			}
			zero = 0;

			belt.add(0, belt.remove(end));
			robot.add(0, robot.remove(end));
			if (robot.get(out)) {
				robot.set(out, false);
			}

			for (int i = out; i > 0; i--) { // 윗부분회전
				if (!robot.get(i) && robot.get(i - 1) && belt.get(i) != 0) {
					robot.set(i, true);
					belt.set(i, belt.get(i) - 1);
					robot.set(i - 1, false);
				}
				if (belt.get(i) == 0) {
					zero++;
				}
			}
			if (robot.get(out)) { // 버리기
				robot.set(out, false);
			}

			if (!robot.get(in) && robot.get(end) && belt.get(in) != 0) { // 끝,시작부분연산
				robot.set(in, true);
				belt.set(in, belt.get(in) - 1);
				robot.set(end, false);
			}

			for (int i = end; i > out; i--) { // 아래부분회전
				if (!robot.get(i) && robot.get(i - 1) && belt.get(i) != 0) {
					robot.set(i, true);
					belt.set(i, belt.get(i) - 1);
					robot.set(i - 1, false);
				}
				if (belt.get(i) == 0) {
					zero++;
				}
			}

			if (!robot.get(in) && belt.get(in) != 0) { // load
				belt.set(in, belt.get(in) - 1);
				robot.set(in, true);
			}
			if (belt.get(in) == 0) {
				zero++;
			}
			count++;
		}

		System.out.println(count);
	}
}