import java.util.*;
import java.io.*;

public class Main {
    static String S, T;
    static int answer;
    static boolean finished;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        st = new StringTokenizer(br.readLine());
        T = st.nextToken();

        answer = 0;
        finished = false;
        dfs(S);
        System.out.println(answer);
    }

    static void dfs(String idx) {
        if(T.equals(idx)) {
            answer =1;
            finished = true;
            return;
        }
        if (!finished && idx.length() < T.length()) {
            StringBuilder A = new StringBuilder();
            StringBuilder B = new StringBuilder();
            A.append(idx);
            B.append(idx);

            A.append('A');
            String strA = A.toString();
            String revA = (A.reverse()).toString();
            if (T.contains(strA) || T.contains(revA)) {
                dfs(strA);
            }

            B.reverse();
            B.append('B');
            String strB = B.toString();
            String revB = (B.reverse()).toString();
            if (T.contains(strB) || T.contains(revB)) {
                dfs(strB);
            }
        }
    }
}