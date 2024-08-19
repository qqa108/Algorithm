import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int alphabet[] = new int[26];

        for(int i=0; i<s.length(); i++) {
            int ascii = s.charAt(i);
            alphabet[ascii-97]++;
        }
        for(int i=0; i<25; i++) {
            System.out.print(alphabet[i] + " ");
        }
        System.out.print(alphabet[25]);

        scanner.close();
    }
}