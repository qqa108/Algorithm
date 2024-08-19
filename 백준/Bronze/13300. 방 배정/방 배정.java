import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int room[][] = new int[7][2];

        for(int i=0; i<N; i++) {
            int gender = scanner.nextInt();
            int grade = scanner.nextInt();

            room[grade][gender]++;
        }

        int count = 0;

        for(int i=1; i<7; i++) {
            if(room[i][0] % K != 0) {
                count = count + (room[i][0]) / K + 1;
            }
            else {
                count = count + (room[i][0]) / K;
            }

            if(room[i][1] % K != 0) {
                count = count + (room[i][1]) / K + 1;
            }
            else {
                count = count + (room[i][1]) / K;
            }
        }
        System.out.println(count);

        scanner.close();
    }
}