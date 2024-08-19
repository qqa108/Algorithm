import java.util.*;

public class Main {
    static char toLower(char c) {
        if((int)c >=65 && (int)c<=90) {
            return (char)((int)(c+32));
        }
        else {
            return c;
        }
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int alphabet[] = new int[26];

        for(int i=0; i<s.length(); i++) {
            char c = toLower(s.charAt(i));
            alphabet[(int)c-97]++;
        }

        int max=0;
        for(int i=0; i<26; i++) {
            if(alphabet[i]>max) {
                max=alphabet[i];
            }
        }

        int answer = 0;
        int index = 0;
        for(int i=0; i<26; i++) {
            if(alphabet[i]==max) {
                answer++;
                index = i;
            }
        }
        if(answer==1) {
            System.out.println((char)(index+65));
        }
        else {
            System.out.println("?");
        }

        scanner.close();
    }
}