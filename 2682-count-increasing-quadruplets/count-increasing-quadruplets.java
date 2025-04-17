class Solution {
    public long countQuadruplets(int[] nums) {
        int[][] less_dp = new int[nums.length][nums.length];
        int[][] high_dp = new int[nums.length][nums.length];
        //computing less than dp
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                less_dp[i][j] = (j == 0)? less_dp[i][j] : less_dp[i][j-1];
                if(nums[j] < nums[i]) less_dp[i][j]++;
            }
        }
        for(int i = nums.length-2; i >= 0; i--){
            for(int j = nums.length - 1; j > i; j--){
                high_dp[i][j] = (j == nums.length-1)?
                                high_dp[i][j]:high_dp[i][j+1];
                if(nums[i] < nums[j]) high_dp[i][j]++;
            }
        }
        long res = 0;
        for(int j = 1; j < nums.length-2; j++){
            for(int k = j+1; k < nums.length-1; k++){
                if(nums[j] > nums[k]){
                    int low_than_k = less_dp[k][j-1];
                    int high_than_j = high_dp[j][k+1];
                    res += (long)low_than_k * (long)high_than_j;
                }
            }
        }
        return res;
    }
}