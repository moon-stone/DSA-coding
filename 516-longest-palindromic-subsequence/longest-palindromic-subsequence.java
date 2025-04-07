class Solution {
    public int cal(String s, int[][] dp, int start, int end){
        if(start == end) return 1;
        if(end < start) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        int take = 0, notTake = 0;
        if(s.charAt(start) == s.charAt(end)){
            take = 2 + cal(s, dp, start+1, end-1);
        } else notTake = Math.max(cal(s, dp, start, end-1), cal(s, dp, start+1, end));
        return dp[start][end] = Math.max(take, notTake);
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++)
            for(int j = 0; j < s.length(); j++)
                dp[i][j] = -1;
        return cal(s, dp, 0, s.length()-1);
    }
}