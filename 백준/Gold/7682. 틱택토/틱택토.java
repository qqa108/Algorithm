import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int result[];
    static HashMap<String, Integer> hash;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        result = new int[9];
        hash = new HashMap<>();

        dfs(0);
        while (true) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("end")) {
                break;
            }
            if (hash.containsKey(s)) {
                sb.append("valid\n");
            }
            else {
                sb.append("invalid\n");
            }
        }
        System.out.print(sb);
    }

    static void dfs(int turn) {
        boolean check = false;

        if ((result[0] != 0 && result[0] == result[1] && result[1] == result[2]) ||
                (result[3] != 0 && result[3] == result[4] && result[4] == result[5]) ||
                (result[6] != 0 && result[6] == result[7] && result[7] == result[8]) ||
                (result[0] != 0 && result[0] == result[3] && result[3] == result[6]) ||
                (result[1] != 0 && result[1] == result[4] && result[4] == result[7]) ||
                (result[2] != 0 && result[2] == result[5] && result[5] == result[8]) ||
                (result[0] != 0 && result[0] == result[4] && result[4] == result[8]) ||
                (result[2] != 0 && result[2] == result[4] && result[4] == result[6])) {
            check = true;
        }
        if (turn == 9) {
            check = true;
        }
        if (check) {
            String s = "";
            for (int i = 0; i < 9; i++) {
                if (result[i] == 0) {
                    s = s + ".";
                }
                else if (result[i] == 1) {
                    s = s + "X";
                }
                else {
                    s = s + "O";
                }
            }
            if (!hash.containsKey(s)) {
                hash.put(s, 1);
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (result[i] == 0) {
                result[i] = (turn % 2) + 1;
                dfs(turn + 1);
                result[i] = 0;
            }
        }
    }
}