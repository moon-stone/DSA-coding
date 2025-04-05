class Solution {
    public int cal(int[] nums, int ind, int xor){
        if(ind == nums.length) return xor;
        int take = cal(nums, ind+1, xor^nums[ind]);
        int notTake = cal(nums, ind+1, xor);
        return take+notTake;
    }
    public int subsetXORSum(int[] nums) {
        return cal(nums, 0, 0);
    }
}