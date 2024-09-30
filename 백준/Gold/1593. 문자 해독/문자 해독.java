import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String W = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        HashMap<Character, Integer> hash = new HashMap<>();
        HashMap<Character, Integer> move = new HashMap<>();

        char c = 'A';
        for (int i = 0; i < 26; i++) {
            move.put(c, 0);
            hash.put(c++, 0);
        }
        c = 'a';
        for (int i = 0; i < 26; i++) {
            move.put(c, 0);
            hash.put(c++, 0);
        }

        for (int i = 0; i < N; i++) {
            hash.put(W.charAt(i), hash.get(W.charAt(i)) + 1);
            move.put(S.charAt(i), move.get(S.charAt(i)) + 1);
        }

        int count = 0;
        for (int i = 0; i < M - N + 1; i++) {
            boolean check = true;
            c = 'a';

            for (char key : hash.keySet()) {
                if (hash.get(key) != move.get(key)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                count++;
            }
            if (i + N >= M) {
                break;
            }
            move.put(S.charAt(i), move.get(S.charAt(i)) - 1);
            move.put(S.charAt(i + N), move.get(S.charAt(i + N)) + 1);
        }
        System.out.println(count);
    }
}