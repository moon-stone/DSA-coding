class Solution {
    public int dfs(ArrayList<Integer> arr, int[][] dp, int i, int j){
        if(j - i <= 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = Integer.MAX_VALUE;
        for(int k = i+1; k < j; k++){
            dp[i][j] = Math.min(dp[i][j], arr.get(j) - arr.get(i) + dfs(arr, dp, i, k) +
            dfs(arr, dp, k, j));
        }
        return dp[i][j];
    }
    public int minCost(int n, int[] cuts) {
        var arr = new ArrayList<Integer>();
        for(int i = 0; i < cuts.length; i++) arr.add(cuts[i]);
        arr.add(0);
        arr.add(n);
        arr.sort((a, b) -> a - b);
        int[][] dp = new int[arr.size()][arr.size()];
        for(int i = 0; i < arr.size(); i++)
            for(int j = 0; j < arr.size(); j++) dp[i][j] = -1;
        return dfs(arr, dp, 0, arr.size()-1);
    }
}