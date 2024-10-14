import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int h = citations.length;
        while(true) {
            int idx = citations.length - 1;
            int count = 0;
            
            while(true) {
                if(idx < 0) {
                    break;
                }
                if(citations[idx] > h) {
                    count++;
                }
                else {
                    break;
                }
                idx--;
            }
            if(h == count) {
                break;
            }
            h--;
        }
        int answer = h;
        return answer;
    }
}