import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int room[] = new int[N];

        for(int i=0; i<N; i++) {
            room[i] = scanner.nextInt();
        }
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        long count = 0;
        for(int i=0; i<N; i++) {
            room[i] = room[i] - B;
            count++;
            if(room[i] <= 0) {
            }
            else {
                if(room[i] <= C) {
                    count++;
                }
                else if(room[i] > C && room[i] % C == 0) {
                    count = count + (room[i] / C);
                }
                else {
                    count = count + (room[i] / C) + 1;
                }
            }
            //System.out.println("*" + count);
        }
        System.out.println(count);

        scanner.close();
    }
}