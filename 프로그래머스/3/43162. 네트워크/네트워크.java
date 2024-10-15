class Solution {
    static int N;
    static boolean visit[];
    static int arr[][];
    
    public int solution(int n, int[][] computers) {
        arr = computers;
        visit = new boolean[n];
        N = n;
        int answer = 0;
        for(int i=0; i<n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                answer++;
                dfs(i);
            }
        }
        
        return answer;
    }
    
    static void dfs(int i) {
        for(int j=0; j<N; j++) {
            if(i != j && !visit[j] && arr[i][j] == 1) {
                visit[j] = true;
                dfs(j);
            }
        }
    }
}