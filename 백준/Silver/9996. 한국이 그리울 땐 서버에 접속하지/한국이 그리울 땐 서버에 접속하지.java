import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String pattern = scanner.next();
        char word[] = pattern.toCharArray();
        int frontlength = 0;
        int backlentgh = 0;
        
        for(int i=0; i<word.length; i++) {
            if(word[i] == '*') {
                frontlength = i;
                backlentgh = word.length-1-i;
                break;
            }
        }
        char front[] = new char[frontlength];
        char back[] = new char[backlentgh];

        for(int i=0; i<front.length; i++) {
            front[i] = word[i];
        }
        for(int i=0; i<back.length; i++) {
            back[i] = word[frontlength+1+i];
        }

        for(int i=0; i<n; i++) {
            String s = scanner.next();
            int count = 0;

            for(int j=0; j<frontlength; j++) {
                if(frontlength > s.length()) {
                    count++;
                    break;
                }
                if(front[j] == s.charAt(j)) {
                }
                else {
                    count++;
                    break;
                }
            }
            for(int j=0; j<backlentgh; j++) {
                if(backlentgh > s.length()) {
                    count++;
                    break;
                }
                if(s.length() < 2) {
                    count++;
                    break;
                }
                if(back[j] == s.charAt(s.length()-backlentgh+j)) {
                }
                else {
                    count++;
                    break;
                }
            }
            if(s.length() < frontlength+backlentgh) {
                count++;
            }
            if(count == 0) {
                System.out.println("DA");
            }
            else {
                System.out.println("NE");
            }
        }
      
        scanner.close();
    }
}