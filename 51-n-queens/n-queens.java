class Solution {
    public boolean checkRowColQueen(int[][] dp, int row, int col){
        for(int i = 0; i < dp.length; i++){
            if(dp[i][col] == 1) return false;
            if(dp[row][i] == 1) return false;
        }
        return true;
    }
    public boolean checkLeftDiag(int[][] dp, int row, int col, int n){
        if(row < 0 || row >= n) return true;
        if(col < 0 || col >= n) return true;
        if(dp[row][col] == 1) return false;
        return checkLeftDiag(dp, row-1, col-1, n);
    }
    public boolean checkRightDiag(int[][] dp, int row, int col, int n){
        if(row < 0 || row >= n) return true;
        if(col < 0 || col >= n) return true;
        if(dp[row][col] == 1) return false;
        return checkRightDiag(dp, row-1, col+1, n);
    }
    public boolean checkDiagQueen(int[][] dp, int row, int col, int n){
        if(row >= n || col >= n) return true;
        if(row < 0 || col < 0) return true;
        if(dp[row][col] == 1) return false;
        return checkLeftDiag(dp, row, col, n) && checkRightDiag(dp, row, col, n);
    }
    public boolean addToRes(int[][] dp, List<List<String>> res){
        List<String> temp_res = new ArrayList<>();
        for(int i = 0; i < dp.length; i++){
            String rowStr = "";
            for(int j = 0; j < dp[0].length; j++){
                if(dp[i][j] == 1) rowStr += "Q";
                else rowStr += ".";
            }
            temp_res.add(rowStr);
        }
        res.add(temp_res);
        return true;
    }
    public boolean backtrackQueens(int[][] dp, List<List<String>> res, int row, int n){
        if(row >= n) return true;
        // System.out.println(row+" ");
        for(int i = 0; i < n; i++){
            // if(dp[0][1] == 1 && dp[1][3] == 1 && dp[2][0] == 1 && row == 3){
            //     System.out.println(row +" "+i+" "+checkRowColQueen(dp, row, i) +" "+checkDiagQueen(dp, row, i, n));
            // }
            if(checkRowColQueen(dp, row, i) && checkDiagQueen(dp, row, i, n)){
                // System.out.println(row+" "+i);
                dp[row][i] = 1;
                // System.out.println(row +" "+i);
                if(backtrackQueens(dp, res, row+1, n)){
                    if(row == n-1){
                        addToRes(dp, res);
                        dp[row][i] = 0;
                        return true;
                    }
                }
                dp[row][i] = 0;
            }
        }
        return false;
    }
    public List<List<String>> solveNQueens(int n) {
        int[][] dp = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        backtrackQueens(dp, res, 0, n);
        return res;
    }
}