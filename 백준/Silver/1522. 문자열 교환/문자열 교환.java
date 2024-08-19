import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char arr[] = s.toCharArray();
        
        int slice = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 'a') {
                slice++;
            }
        }
        int min = arr.length;
        for(int i=0; i<arr.length; i++) {
            int count = 0;
            
            for(int j=i; j<i+slice; j++) {
                if(arr[j%arr.length] == 'b') {
                    count++;
                }
            }
            if(min > count) {
                min = count;
            }
        }
        System.out.println(min);

        scanner.close();
    }
}
