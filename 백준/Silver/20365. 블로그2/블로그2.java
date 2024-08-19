import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        char color[] = s.toCharArray();
        char first;
        char second;
        int count = 1;
        
        if(color[0] == 'B') {
            first = 'B';
            second = 'R';
        }
        else {
            first = 'R';
            second = 'B';
        }

        for(int i=1; i<color.length; i++) {
            if(color[i-1] == first && color[i] == second) {
                count++;
            }
        }
        System.out.println(count);
        
        scanner.close();
    }
}