import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int arr[][] = new int[2][4];
		for (int tc = 0; tc < 4; tc++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (arr[0][3] < arr[1][1] || arr[0][2] < arr[1][0] || arr[0][1] > arr[1][3] || arr[0][0] > arr[1][2]) {
				System.out.println("d");
			} else if ((arr[0][2] == arr[1][0] && arr[0][3] == arr[1][1])
					|| (arr[0][2] == arr[1][0] && arr[0][1] == arr[1][3])
					|| (arr[0][0] == arr[1][2] && arr[0][1] == arr[1][3])
					|| (arr[0][0] == arr[1][2] && arr[0][3] == arr[1][1])) {
				System.out.println("c");
			} else if (arr[0][3] == arr[1][1] || arr[0][2] == arr[1][0] || arr[0][1] == arr[1][3]
					|| arr[0][0] == arr[1][2]) {
				System.out.println("b");
			} else {
				System.out.println("a");
			}
		}
	}
}