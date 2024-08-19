import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String firstword = scanner.next();
        char firstwordarray[] = firstword.toCharArray();
        int result = 0;

        for(int i=0; i<num-1; i++) {
            String word = scanner.next();
            char wordarray[] = word.toCharArray();
            int count = 0;
            int find = 0;

            if(firstwordarray.length < wordarray.length) {
                count = count + wordarray.length - firstwordarray.length;
            }
            for(int j=0; j<firstwordarray.length; j++) {
                find = 0;
                for(int k=0; k<wordarray.length; k++) {
                    if(firstwordarray[j] == wordarray[k]) {
                        wordarray[k] = '0';
                        find++;
                        break;
                    }
                }
                if(find == 0) {
                    count++;
                }
            }
            if(count <= 1) {
                result++;
            }
        }
        System.out.println(result);
        
        scanner.close();
    }
}