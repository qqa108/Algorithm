import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int t = sc.nextInt();

		int xline = (y + t) / h;
		int yline = (x + t) / w;

		x = (x + t) % w;
		y = (y + t) % h;

		if (xline % 2 != 0) {
			y = h - y;
		}
		if (yline % 2 != 0) {
			x = w - x;
		}
		System.out.println(x + " " + y);
		sc.close();
	}
}