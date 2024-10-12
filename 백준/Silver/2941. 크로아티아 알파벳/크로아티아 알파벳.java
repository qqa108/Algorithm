import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        char arr[] = s.toCharArray();

        int idx = arr.length - 1;
        int count = 0;
        while(idx >= 0) {
            if(arr[idx] == '=') {
                if(idx - 2 >= 0 && arr[idx-1]=='z' && arr[idx-2]=='d') {
                    idx = idx - 2;
                }
                if(idx - 1 >= 0 && (arr[idx-1]=='c' || arr[idx-1]=='s' || arr[idx-1]=='z')) {
                    idx--;
                }
            }
            else if(arr[idx] == '-') {
                if(idx - 1 >= 0 && (arr[idx-1]=='c' || arr[idx-1]=='d')) {
                    idx--;
                }
            }
            else if(arr[idx] == 'j') {
                if(idx - 1 >= 0 && (arr[idx-1]=='l' || arr[idx-1]=='n')) {
                    idx--;
                }
            }
            count++;
            idx--;
        }
        System.out.println(count);
    }
}