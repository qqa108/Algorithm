import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int K = sc.nextInt();
		int arr[][] = new int[R][C];
		int di[] = { -1, 0, 1, 0 };
		int dj[] = { 0, 1, 0, -1 };

		int x = R - 1;
		int y = 0;
		int index = 1;
		int del = 0;
		int answer = 1;
		arr[x][y] = index++;

		if (K > R * C) {
			K = index - 1;
			answer = 0;
		}

		while (true) {
			if (index - 1 == K) {
				break;
			}
			if (x + di[del] < 0 || x + di[del] >= R || y + dj[del] < 0 || y + dj[del] >= C
					|| arr[x + di[del]][y + dj[del]] != 0) {
				del = (del + 1) % 4;
				continue;
			}
			else {
				x = x + di[del];
				y = y + dj[del];
				arr[x][y] = index++;
			}
		}
		if (answer == 0) {
			System.out.println(0);
		}
		else {
			System.out.println((y + 1) + " " + (R - x));
		}
		sc.close();
	}
}