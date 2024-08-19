import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char word[] = new char[s.length()*2];
        int answer = 0;

        for(int i=0; i<s.length(); i++) {
            word[i] = s.charAt(i);
            word[2*s.length()-1-i] = s.charAt(s.length()-1-i);

            if(word[i] == word[2*s.length()-1-i]) {
                answer = 1;
            }
            else {
                answer = 0;
                break;
            }
        }
        System.out.println(answer);

        scanner.close();
    }
}