import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char num[] = s.toCharArray();
        int zerocount = 0;
        int onecount = 0;

        for(int i=0; i<num.length; i++) {
            if(num[i] == '0') {
                zerocount++;
            }
            else {
                onecount++;
            }
        }

        zerocount = zerocount / 2;
        onecount = onecount / 2;

        for(int i=0; i<num.length; i++) {
            if(num[i] == '1') {
                if(onecount > 0) {
                    num[i] = '2';
                    onecount--;
                }
            }
            if(num[num.length-i-1] == '0') {
                if(zerocount > 0) {
                    num[num.length-i-1] = '2';
                    zerocount--;
                }
            }
        }

        for(int i=0; i<num.length; i++) {
            if(num[i] == '2') {
            }
            else {
                System.out.print(num[i]);
            }
        }

        scanner.close();
    }
}