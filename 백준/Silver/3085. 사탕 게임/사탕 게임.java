import java.util.*;

public class Main {
    static int change(char [][]candy, int n, int x, int y) {
        char tmp;
        tmp = candy[x][y];
        candy[x][y] = candy[x][y+1];
        candy[x][y+1] = tmp;

        int max = count(candy, n, x, y);

        tmp = candy[x][y];
        candy[x][y] = candy[x][y+1];
        candy[x][y+1] = tmp;

        return max;
    }
    static int count(char [][]candy, int n, int x, int y) {
        int max = 1;
        int count1 = 1;
        int count2 = 1;
        int count3 = 1;
        for(int i=1; i<n; i++) {
            
            if(candy[i][y] == candy[i-1][y]) {
                count1++;
            }
            else {
                count1 = 1;
            }
            if(max < count1) {
                max = count1;
            }
           
            if(candy[i][y+1] == candy[i-1][y+1]) {
                count2++;
            }
            else {
                count2 = 1;
            }
            if(max < count2) {
                max = count2;
            }

            if(candy[x][i] == candy[x][i-1]) {
                count3++;
            }
            else {
                count3 = 1;
            }
            if(max < count3) {
                max = count3;
            }
        }
        return max;
    };
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char candyx[][] = new char[n][n];
        char candyy[][] = new char[n][n];

        for(int i=0; i<n; i++) {
            String s = scanner.next();
            for(int j=0; j<n; j++) {
                candyx[i][j] = s.charAt(j);
                candyy[j][i] = s.charAt(j);
            }
        }

        int max = 0;
        int count;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n-1; j++) {    
                count = change(candyx, n, i, j);
                if(max < count) {
                    max = count;
                }
                count = change(candyy, n, i, j);
                if(max < count) {
                    max = count;
                }
            }
        }
        System.out.println(max);

        scanner.close();
    }
}