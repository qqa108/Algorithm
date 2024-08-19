import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		if (s.length() == 1 && s.charAt(0) == '\"') {
			System.out.println("CE");
			return;
		}

		if (s.startsWith("\"") && s.endsWith("\"")) {
			String tmp = s.substring(1, s.length() - 1).trim();
			if (tmp.isEmpty()) {
				System.out.println("CE");
			} else {
				System.out.println(tmp);
			}
		} else {
			System.out.println("CE");
		}
	}
}