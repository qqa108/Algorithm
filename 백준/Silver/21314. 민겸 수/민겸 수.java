import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char mk[] = s.toCharArray();
        String max = "";
        String min = "";
        String maxnum = "";
        String minnum = "1";
        int count = 0;

        for(int i=0; i<mk.length; i++) {
            if(mk[i] == 'K') {
                max = max + 5 + maxnum;
                maxnum = "";

                if(count == 0) {
                    min = min + 5;
                }
                else {
                    min = min + minnum + 5;
                }
                minnum = "1";

                count = 0;
            }
            else {
                maxnum = maxnum + 0;
                if(count != 0) {
                    minnum = minnum + 0;
                }
                count++;
            }
        }
        if(count != 0) {
            min = min + 1;
            for(int i=0; i<count; i++) {
                max = max + 1;
                if(i != 0) {
                    min = min + 0;
                }
            }
        }
        
        System.out.println(max);
        System.out.println(min);

        scanner.close();
    }
}