import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char arr[] = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		int stick = 0;
		int sum = 0;
		char pre = ' ';

		for (int i = 0; i < s.length(); i++) {
			if (arr[i] == '(') {
				stack.push(arr[i]);
				stick++;
				sum++;
			}
			else {
				stack.pop();
				stick--;

				if (pre == '(') {
					sum = sum + stick;
					sum--;
				}

			}
			pre = arr[i];
		}
		System.out.println(sum);

		br.close();
	}
}