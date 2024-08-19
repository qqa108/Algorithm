import java.util.*;

public class Main {
    static char toRot13(char s) {
        
        if((int)s>=65 && (int)s<=77) {
            return (char)((int)(s+13));
        }
        else if((int)s>=78 && (int)s<=90) {
            return (char)((int)(s-13));
        }
        else if((int)s>=97 && (int)s<=109) {
            return (char)((int)(s+13));
        }
        else if((int)s>=110 && (int)s<=122) {
            return (char)((int)(s-13));
        }
        else {
            return s;
        }
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char rot13[] = new char[s.length()];

        for(int i=0; i<s.length(); i++) {
            rot13[i] = toRot13(s.charAt(i));
            System.out.print(rot13[i]);
        }

        scanner.close();
    }
}