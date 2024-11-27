import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int answer = 0;
        if (N % 4 == 0 && (N % 100 != 0 || N % 400 == 0)) {
            answer = 1;
        }
        System.out.println(answer);
    }
}