import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int weight[] = new int[n];
        int height[] = new int[n];
        int rank[] = new int[n];

        for(int i=0; i<n; i++) {
            weight[i] = scanner.nextInt();
            height[i] = scanner.nextInt();
            rank[i] = 1;
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(weight[j]<weight[i] && height[j]<height[i]) {
                    rank[j]++;
                }
            }
        }
        for(int i=0; i<n; i++) {
            System.out.println(rank[i]);
        }

        scanner.close();
    }
}