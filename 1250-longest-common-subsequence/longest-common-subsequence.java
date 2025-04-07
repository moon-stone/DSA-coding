class Solution {
    public int cal(String text1, String text2, int[][] dp, int ind1, int ind2){
        if(ind1 <= 0 || ind2 <= 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        int take = 0, notTake = 0;
        if(text1.charAt(ind1-1) == text2.charAt(ind2-1)){
            take = 1 + cal(text1, text2, dp, ind1-1, ind2-1);
        }
        else notTake = Math.max(cal(text1, text2, dp, ind1-1, ind2), cal(text1, text2, dp, ind1, ind2-1));
        return dp[ind1][ind2] = Math.max(take, notTake);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i = 0; i <= text1.length(); i++)
            for(int j = 0; j <= text2.length(); j++)
                dp[i][j] = -1;
        return cal(text1, text2, dp, text1.length(), text2.length());
    }
}