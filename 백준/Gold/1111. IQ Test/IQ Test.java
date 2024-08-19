import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int state = 0;
		int answer = 0;
		if (N == 1) {
			state = 1;
		}
		else if (N == 2) {
			if (arr[2] == arr[1]) {
				answer = arr[1];
			}
			else {
				state = 1;
			}
		}
		else {
			if (arr[2] - arr[1] == 0) {
				for (int i = 2; i < N; i++) {
					if (arr[i + 1] - arr[i] != 0) {
						state = 2;
						break;
					}
				}
				if (state == 0) {
					answer = arr[1];
				}
			}
			else {
				if (arr[3] - arr[2] == 0) {
					for (int i = 2; i < N; i++) {
						if (arr[i + 1] - arr[i] != 0) {
							state = 2;
							break;
						}
					}
					if (state == 0) {
						answer = arr[2];
					}
				}
				else {
					if ((arr[3] - arr[2]) % (arr[2] - arr[1]) != 0) {
						state = 2;
					}
					else {
						int a = (arr[3] - arr[2]) / (arr[2] - arr[1]);
						int b = arr[2] - (arr[1] * a);

						for (int i = 1; i < N; i++) {
							int next = (arr[i] * a) + b;
							if (next != arr[i + 1]) {
								state = 2;
								break;
							}
						}
						if (state == 0) {
							answer = (arr[N] * a) + b;
						}
					}
				}

			}
		}
		if (state == 0) {
			System.out.println(answer);
		}
		else if (state == 1) {
			System.out.println("A");
		}
		else {
			System.out.println("B");
		}
	}
}