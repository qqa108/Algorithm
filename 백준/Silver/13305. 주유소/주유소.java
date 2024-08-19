import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long distance[] = new long[n-1];
        long city[] = new long[n];

        long arrive = 0;
        for(int i=0; i<n-1; i++) {
            distance[i] = scanner.nextInt();
            arrive = arrive + distance[i];
        }

        long lowprice = 1000000000;
        for(int i=0; i<n-1; i++) {
            city[i] = scanner.nextInt();
            if(city[i] < lowprice) {
                lowprice = city[i];
            }
        }

        long price = 0;
        for(int i=0; i<n-1; i++) {
            if(city[i] == lowprice) {
                price = price + city[i]*arrive;
                break;
            }
            else {
                if(city[i] < city[i+1]) {
                    city[i+1] = city[i];
                }
                price = price + city[i]*distance[i];
                arrive = arrive - distance[i];
            }
        }
        System.out.println(price);

        scanner.close();
    }
}