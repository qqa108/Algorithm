import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			Integer.parseInt(br.readLine());
			String s = br.readLine();
			char c[] = s.toCharArray();
			Stack<Character> stack = new Stack<>();
			int answer = 1;

			for (int i = 0; i < s.length(); i++) {
				if (c[i] == '(' || c[i] == '[' || c[i] == '{' || c[i] == '<') {
					stack.push(c[i]);
				}
				else if (c[i] == ')' && stack.pop() != '(') {
					answer = 0;
				}
				else if (c[i] == ']' && stack.pop() != '[') {
					answer = 0;
				}
				else if (c[i] == '}' && stack.pop() != '{') {
					answer = 0;
				}
				else if (c[i] == '>' && stack.pop() != '<') {
					answer = 0;
				}
				if (answer == 0) {
					break;
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
		br.close();
	}
}
