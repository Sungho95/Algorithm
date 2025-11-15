class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] dp = new int[size][size];
        
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        int answer = 0;
        for (int j = 0; j < size; j++) {
            answer = Math.max(answer, dp[size - 1][j]);
        }
        
        return answer;
    }
}