import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        Num arr[] = new Num[numbers.length];
        
        for(int i=0; i<arr.length; i++) {
            arr[i] = new Num(""+numbers[i]);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--) {
            sb.append(arr[i].num);
        }
        
        String answer = sb.toString();
        boolean check = false;
        for(int i=0; i<answer.length(); i++) {
            if(answer.charAt(i) != '0') {
                check = true;
                break;
            }
        }
        if(!check) {
            return "0";
        }
        return sb.toString();
    }
    static class Num implements Comparable<Num>{
        String num;
        
        Num(String num) {
            this.num = num;
        }
        
        @Override
        public int compareTo(Num o) {
            int left = Integer.parseInt(this.num + o.num);
            int right = Integer.parseInt(o.num + this.num);
            
            return left - right;
        }
        
    }
}