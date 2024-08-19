import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n*n];
        int index = 0;

        for(int i=0; i<n; i++) {
            String []s = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                arr[index++] = Integer.parseInt(s[j]);
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[n*n-n]);

        br.close();
    }
}