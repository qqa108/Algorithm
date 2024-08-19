import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static char arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			arr[i] = s.toCharArray();
		}
		map(0, N, 0, N);
		System.out.println(sb);
		br.close();
	}

	static void map(int startx, int endx, int starty, int endy) {
		if (startx >= endx || starty >= endy) {
			return;
		}
		boolean check = true;
		char pix = arr[startx][starty];
		for (int i = startx; i < endx; i++) {
			for (int j = starty; j < endy; j++) {
				if (arr[i][j] != pix) {
					check = false;
					break;
				}
				if (!check) {
					break;
				}
			}
		}
		if (check || startx >= endx || starty >= endy) {
			sb.append(pix);
			return;
		}
		else {
			sb.append("(");
			map(startx, (startx + endx) / 2, starty, (starty + endy) / 2);
			map(startx, (startx + endx) / 2, (starty + endy) / 2, endy);
			map((startx + endx) / 2, endx, starty, (starty + endy) / 2);
			map((startx + endx) / 2, endx, (starty + endy) / 2, endy);
			sb.append(")");
		}
	}
}