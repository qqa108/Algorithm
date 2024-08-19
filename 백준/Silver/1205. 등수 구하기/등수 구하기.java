import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int score = scanner.nextInt();
        int p = scanner.nextInt();
        int scoreboard[] = new int[p];

        for(int i=0; i<n; i++) {
            scoreboard[i] = -scanner.nextInt();
        }
        for(int i=n; i<p; i++) {
            scoreboard[i] = 1;
        }
        Arrays.sort(scoreboard);
        for(int i=0; i<p; i++) {
            scoreboard[i] = scoreboard[i]*(-1);
        }

        int index = 1;
        for(int i=0; i<p; i++) {
            if(scoreboard[i] > score) {
                index++;
            }
            else if(scoreboard[i] == score) {
                if(i+1 == p) {
                    index = p+1;
                }
            }
            else {
                break;
            }
        }

        if(index == p+1) {
            System.out.println(-1);
        }
        else {
            System.out.println(index);
        }

        scanner.close();
    }
}