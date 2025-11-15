class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(
        int i,
        int[][] computers,
        boolean[] visited,
        int n
    ) {
        visited[i] = true;
        
        for (int j = 0; j < n; j++) {
            if (i != j && computers[i][j] == 1 && !visited[j]) {
                dfs(j, computers, visited, n);
            }
        }
    }
}