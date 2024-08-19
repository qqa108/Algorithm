import java.util.Scanner;

public class Main {
	static int arr[] = new int[3];
	static int A;
	static int B;
	static int C;
	static boolean visit[][][] = new boolean[601][601][601];
	static boolean result[] = new boolean[601];

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();

		visit[0][0][C] = true;
		result[C] = true;
		dfs(0, 0, C);

		for (int i = 0; i < result.length; i++) {
			if (result[i]) {
				sb.append(i).append(' ');
			}
		}
		System.out.println(sb);
		sc.close();
	}

	static void dfs(int a, int b, int c) {
		if (a == 0 && !result[c]) {
			result[c] = true;
		}
		int tmp = 0;
		if (a != 0) { // a->b
			tmp = B - b;
			if (check(a - tmp, b + tmp, c) && !visit[a - tmp][b + tmp][c]) {
				visit[a - tmp][b + tmp][c] = true;
				dfs(a - tmp, b + tmp, c); // a->b
			}
			tmp = a;
			if (check(0, b + tmp, c) && !visit[0][b + tmp][c]) {
				visit[0][b + tmp][c] = true;
				dfs(0, b + tmp, c);
			}

			tmp = C - c;
			if (check(a - tmp, b, c + tmp) && !visit[a - tmp][b][c + tmp]) {
				visit[a - tmp][b][c + tmp] = true;
				dfs(a - tmp, b, c + tmp); // a->c
			}
			tmp = a;
			if (check(0, b, c + tmp) && !visit[0][b][c + tmp]) {
				visit[0][b][c + tmp] = true;
				dfs(0, b, c + tmp);
			}
		}
		if (b != 0) {
			tmp = A - a;
			if (check(a + tmp, b - tmp, c) && !visit[a + tmp][b - tmp][c]) {
				visit[a + tmp][b - tmp][c] = true;
				dfs(a + tmp, b - tmp, c); // b->a
			}
			tmp = b;
			if (check(a + tmp, 0, c) && !visit[a + tmp][0][c]) {
				visit[a + tmp][0][c] = true;
				dfs(a + tmp, 0, c);
			}
			tmp = C - c;
			if (check(a, b - tmp, c + tmp) && !visit[a][b - tmp][c + tmp]) {
				visit[a][b - tmp][c + tmp] = true;
				dfs(a, b - tmp, c + tmp); // b->c
			}
			tmp = b;
			if (check(a, 0, c + tmp) && !visit[a][0][c + tmp]) {
				visit[a][0][c + tmp] = true;
				dfs(a, 0, c + tmp);
			}
		}
		if (c != 0) {
			tmp = A - a;
			if (check(a + tmp, b, c - tmp) && !visit[a + tmp][b][c - tmp]) {
				visit[a + tmp][b][c - tmp] = true;
				dfs(a + tmp, b, c - tmp); // c->a
			}
			tmp = c;
			if (check(a + tmp, b, 0) && !visit[a + tmp][b][0]) {
				visit[a + tmp][b][0] = true;
				dfs(a + tmp, b, 0);
			}
			tmp = B - b;
			if (check(a, b + tmp, c - tmp) && !visit[a][b + tmp][c - tmp]) {
				visit[a][b + tmp][c - tmp] = true;
				dfs(a, b + tmp, c - tmp); // c->b
			}
			tmp = c;
			if (check(a, b + tmp, 0) && !visit[a][b + tmp][0]) {
				visit[a][b + tmp][0] = true;
				dfs(a, b + tmp, 0);
			}
		}
	}

	static boolean check(int a, int b, int c) {
		if (a >= 0 && a <= A && b >= 0 && b <= B && c >= 0 && c <= C) {
			return true;
		}
		return false;
	}
}