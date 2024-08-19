import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int rope[] = new int[n];

        for(int i=0; i<n; i++) {
            rope[i] = scanner.nextInt();
        }

        Arrays.sort(rope);
        int max = rope[0]*n;

        for(int i=0; i<n; i++) {
            if(max < rope[i]*(n-i)) {
                max = rope[i]*(n-i);
            }
        }
        System.out.println(max);

        scanner.close();
    }
}