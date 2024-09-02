import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        String ans = "";
        for (int i = 0; i < N; i++) {
            ans = ans + "IO";
        }
        ans = ans + "I";

        int idx = 0;
        int count = 0;
        while (idx + (2 * N) + 1 <= s.length()) {
            if (ans.equals(s.substring(idx, idx + (2 * N) + 1))) {
                idx = idx + 2;
                count++;
            }
            else {
                idx++;
            }
        }
        System.out.println(count);
    }
}