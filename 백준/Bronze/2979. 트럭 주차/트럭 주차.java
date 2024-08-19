import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int timetable[] = new int[100];
        int min = 0;
        int max = 0;
        int fee = 0;

        for(int i=0; i<3; i++) {
            int start = scanner.nextInt();
            if(min>start) {
                min = start;
            }
            int end = scanner.nextInt();
            if(max<end) {
                max = end;
            }

            for(int j=start; j<end; j++) {
                timetable[j]++;
            }
        }
        for(int i=min; i<max; i++) {
            if(timetable[i] == 1) {
                fee = fee + a;
            }
            else if(timetable[i] == 2) {
                fee = fee + 2*b;
            }
            else if(timetable[i] == 3) {
                fee = fee + 3*c;
            }
            else {

            }
        }
        System.out.println(fee);

        scanner.close();
    }
}