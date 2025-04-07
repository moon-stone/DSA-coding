class Solution {
    public boolean canPartition(int[] nums) {
        int totSum = 0;
        int targetSum = 0;
        boolean[][] dp;
        for(int i = 0; i < nums.length; i++) totSum += nums[i];
        if((totSum & 1) == 1) return false;
        targetSum = totSum/2;
        dp = new boolean[targetSum+1][nums.length];
        for(int i = 0; i <= targetSum; i++){
            for(int j = 0; j < nums.length; j++){
                if(i == 0){
                    dp[i][j] = true;
                    continue;
                }
                if(j == 0){
                    if(i == nums[0]) dp[i][j] = true;
                    else dp[i][j] = false;
                    continue;
                }
               
                dp[i][j] = dp[i][j-1] || (nums[j] > i ? false : dp[i - nums[j]][j-1]); 
            }
        }
        return dp[targetSum][nums.length-1];
    }
}