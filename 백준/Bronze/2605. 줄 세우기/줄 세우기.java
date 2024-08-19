import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List <Integer> list = new ArrayList<>();
        int N = scanner.nextInt();

        for(int i=0; i<N; i++) {
            int num = scanner.nextInt();
            list.add(i - num, i + 1);
        }
        for(int i=0; i<N; i++) {
            System.out.print(list.get(i) + " ");
        }

        scanner.close();
    }
}