import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for(int i=0; i<N; i++) {
			String quiz = sc.next();
			int score = 1;
			int sum = 0;
			
			for(int j=0; j<quiz.length(); j++) {
				if(quiz.charAt(j) == 'O') {
					sum = sum + score;
					score++;
				}
				else {
					score = 1;
				}
			}
			
			System.out.println(sum);
		}
	}
}