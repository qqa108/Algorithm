import java.util.*;

public class Main {
    static int getCount(int[][] board, int n, int m) {
        int count = 0;
        for(int i=n; i<n+8; i++) {
            for(int j=m; j<m+8; j++) {
                if(board[i][j] == 1) {
                    count++;
                }

            }
        }
        return count;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char board[][] = new char[n][m];
        int whitefirst[][] = new int[n][m];
        int blackfirst[][] = new int [n][m];

        for(int i=0; i<n; i++) {
            String s = scanner.next();
            for(int j=0; j<m; j++) {
                board[i][j] = s.charAt(j);
                whitefirst[i][j] = 0;
                blackfirst[i][j] = 0;
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if((i+j) % 2 ==0) {   //Black First
                    if(board[i][j] == 'W') {
                        blackfirst[i][j]++;
                    }
                    else {
                        whitefirst[i][j]++;
                    }
                }
                else {
                    if(board[i][j] == 'B') {
                        blackfirst[i][j]++;
                    }
                    else {
                        whitefirst[i][j]++;
                    }
                }
            }
        }

        int min = 64;

        for(int i=0; i<=n-8; i++) {
            for(int j=0; j<=m-8; j++) {
                int white = getCount(whitefirst, i, j);
                int black = getCount(blackfirst, i, j);

                if(white < min) {
                    min = white;
                }
                if(black < min) {
                    min = black;
                }
            }
        }
        System.out.println(min);

        scanner.close();
    }
}