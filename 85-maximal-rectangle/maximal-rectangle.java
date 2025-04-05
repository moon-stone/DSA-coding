class Solution {
    public int findArea(int[][] dp, int i, int j){
        int curr_row = i;
        int area = 1;
        int length = dp[i][j];
        while(curr_row >= 0 && dp[curr_row][j] > 0){
            int base = (i - curr_row) + 1;
            length = Math.min(dp[curr_row][j], length);
            area = Math.max(area, base*length);
            curr_row--;
        }
        return area;
    }
    public int maximalRectangle(char[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        int res = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == '1'){
                    dp[i][j] = 1;
                    if(j > 0 && dp[i][j-1] > 0) dp[i][j] = dp[i][j-1] + 1;
                }
            }
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(dp[i][j] > 0){
                    res = Math.max(res, findArea(dp, i, j));
                }
            }
        }
        return res;
    }
}