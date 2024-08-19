import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            int arr[] = new int[20];
            int count = 0;

            String[] input = br.readLine().split(" ");
            int number = Integer.parseInt(input[0]);
            int kid = Integer.parseInt(input[1]);
            arr[0] = kid;

            for(int j=1; j<20; j++) {
                kid = Integer.parseInt(input[j+1]);
                arr[j] = kid;

                for(int k=j-1; k>=0; k--) {
                    if(arr[k]>arr[k+1]) {
                        int tmp = arr[k];
                        arr[k] = arr[k+1];
                        arr[k+1] = tmp;
                        count++;
                    }
                }
            }
            bw.write(number + " " + count + "\n");
        }
        
        br.close();
        bw.close();
    }
}