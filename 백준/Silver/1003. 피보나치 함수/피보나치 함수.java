import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Dp []dp = new Dp[41];
        dp[0] = new Dp(1,0);
        dp[1] = new Dp(0,1);
        for(int i=2; i<=40; i++) {
            int zero = dp[i-1].zero + dp[i-2].zero;
            int one = dp[i-1].one + dp[i-2].one;
            dp[i] = new Dp(zero, one);
        }

        int T = Integer.parseInt(st.nextToken());

        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            sb.append(dp[N].zero).append(' ').append(dp[N].one).append('\n');
        }
        System.out.print(sb);
    }

    static class Dp {
        int zero, one;

        public Dp(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }
}