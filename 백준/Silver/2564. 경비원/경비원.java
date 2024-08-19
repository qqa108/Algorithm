import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int n = sc.nextInt();
		int arr[][] = new int[h + 1][w + 1];
		int di[] = { 0, -1, 0, 1 };
		int dj[] = { -1, 0, 1, 0 };
		int start = 0;

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (a == 1) {
				arr[0][b] = i + 1;
			}
			else if (a == 2) {
				arr[h][b] = i + 1;
			}
			else if (a == 3) {
				arr[b][0] = i + 1;
			}
			else if (a == 4) {
				arr[b][w] = i + 1;
			}
		}

		int a = sc.nextInt();
		int b = sc.nextInt();
		int startx = 0;
		int starty = 0;

		if (a == 1) {
//			arr[0][b] = 0;
			start = 2;
			startx = 0;
			starty = b;
		}
		else if (a == 2) {
//			arr[h - 1][b] = 0;
			start = 0;
			startx = h;
			starty = b;
		}
		else if (a == 3) {
//			arr[b][0] = 0;
			start = 1;
			startx = b;
			starty = 0;
		}
		else if (a == 4) {
//			arr[b][w - 1] = 0;
			start = 3;
			startx = b;
			starty = w;
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			int index = start;
			int x = startx;
			int y = starty;
			int min = 0;
			int count = 0;

			while (true) {
				if (arr[x][y] == i + 1) {
					min = Math.min(count, 2 * w + 2 * h - count);
					break;
				}
				if (x + di[index] < 0 || x + di[index] > h || y + dj[index] < 0 || y + dj[index] > w) {
					index = (index + 1) % 4;
				}
				x = x + di[index];
				y = y + dj[index];
				count++;

			}
			sum = sum + min;
		}
		System.out.println(sum);

		sc.close();
	}
}