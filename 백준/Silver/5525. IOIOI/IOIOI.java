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

        int idx = 0;
        int cnt = 0;
        int answer = 0;

        while (idx < S) {
            if (idx + 2 < S && s.charAt(idx) == 'I' && s.charAt(idx + 1) == 'O' && s.charAt(idx + 2) == 'I') {
                cnt++;
                idx = idx + 2;
            }
            else {
                if (cnt >= N) {
                    answer = answer + cnt - N + 1;
                    cnt = 0;
                    continue;
                }
                cnt = 0;
                idx++;
            }
        }
        if (cnt >= N) {
            answer = answer + cnt - N + 1;
        }
        System.out.println(answer);
    }
}