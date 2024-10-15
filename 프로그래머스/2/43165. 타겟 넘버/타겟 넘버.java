class Solution {
    static int N;
    static int arr[];
    static int t;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        arr = numbers;
        t = target;
        answer = 0;
        dfs(0,0);
        return answer;
    }
    
    static void dfs(int idx, int sum) {
        if(idx == N) {
            if(sum == t) {
                answer++;
            }
            return;
        }
        dfs(idx+1, sum-arr[idx]);
        dfs(idx+1, sum+arr[idx]);
    }
}