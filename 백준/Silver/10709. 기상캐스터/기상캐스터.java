import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int weathertime[][] = new int[h][w];

        for(int i=0 ; i<h; i++) {
            String s = scanner.next();
            char cloud[] = new char[w];
            int cloudtime = -1;

            for(int j=0; j<w; j++) {
                cloud[j] = s.charAt(j);

                if(cloud[j] == 'c') {
                    cloudtime = 0;
                    weathertime[i][j] = 0;
                    cloudtime++;
                }
                else if(cloudtime == -1) {
                    weathertime[i][j] = cloudtime;
                }
                else {
                    weathertime[i][j] = cloudtime;
                    cloudtime++;
                }
            }
        }

        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(j == w-1) {
                    System.out.println(weathertime[i][j]);
                }
                else {
                    System.out.print(weathertime[i][j] + " ");
                }
                
            }
        }
      
        scanner.close();
    }
}