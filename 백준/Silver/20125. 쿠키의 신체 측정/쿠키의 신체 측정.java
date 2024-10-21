import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char arr[][] = new char[N][N];

        int hi = 0, hj = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
                if (hi == 0 && hj == 0 && arr[i][j] == '*') {
                    hi = i + 1;
                    hj = j;
                }
            }
        }

        int leftArm = 0, rightArm = 0, core = 0, leftLeg = 0, rightLeg = 0;
        for (int j = hj - 1; j >= 0; j--) {
            if (arr[hi][j] != '*') {
                break;
            }
            leftArm++;
        }
        for (int j = hj + 1; j < N; j++) {
            if (arr[hi][j] != '*') {
                break;
            }
            rightArm++;
        }
        for (int i = hi + 1; i < N; i++) {
            if (arr[i][hj] != '*') {
                break;
            }
            core++;
        }
        for (int i = hi + core + 1; i < N; i++) {
            if (arr[i][hj - 1] != '*') {
                break;
            }
            leftLeg++;
        }
        for (int i = hi + core + 1; i < N; i++) {
            if (arr[i][hj + 1] != '*') {
                break;
            }
            rightLeg++;
        }
        System.out.println((hi + 1) + " " + (hj + 1));
        System.out.println(leftArm + " " + rightArm + " " + core + " " + leftLeg + " " + rightLeg);

    }
}