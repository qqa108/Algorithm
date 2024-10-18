import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String T = st.nextToken();

        while (T.length() > S.length()) {
            int idx = T.length() - 1;
            char ch = T.charAt(idx);
            if (ch == 'A') {
                T = T.substring(0, idx);
            } else if (ch == 'B') {
                T = T.substring(0, idx);
                T = new StringBuilder(T).reverse().toString();
            }
        }
        if (T.equals(S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

}