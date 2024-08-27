import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char arr[];
    static int answer;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            arr = s.toCharArray();

            answer = 2;
            dfs(0, arr.length - 1, 0);
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int left, int right, int count) {
        if (left >= right) {
            answer = Math.min(answer, count);
            return;
        }
        if (arr[left] == arr[right]) {
            dfs(left + 1, right - 1, count);
        }
        else if (count == 0) {
            if (arr[left + 1] == arr[right]) {
                dfs(left + 1, right, count + 1);
            }
            if (arr[left] == arr[right - 1]) {
                dfs(left, right - 1, count + 1);
            }
        }
        else {
            answer = Math.min(answer, 2);
        }
    }
}