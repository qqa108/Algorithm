import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char a = s.charAt(0);
		if(a == 'N' || a== 'n') {
			System.out.println("Naver D2");
		}
		else {
			System.out.println("Naver Whale");
		}
	}
}