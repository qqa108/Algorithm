import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int count5=0;
        int count2=0;
        int result = 0;

        if(money == 3 || money == 1) {
            result = -1;
        }
        else {
            if((money%5)%2 != 0 ) {
                count5 = money/5 - 1;
            }
            else {
                count5 = money/5;
            }
            money = money - count5*5;
            count2 = money/2;
            result = count5 + count2;
        }
        System.out.println(result);
        
        scanner.close();
    }
}