import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int firstname[] = new int[26];
        int answer = 0;

        for(int i=0; i<n; i++) {
            String s = scanner.next();
            int ascii = s.charAt(0);
            firstname[ascii-97]++;
        }
        for(int i=0; i<26; i++) {
            if(firstname[i]>=5) {
                System.out.print((char)(97+i));
                answer++;
            }
        }
        if(answer == 0) {
            System.out.println("PREDAJA");
        }

        scanner.close();
    }
}