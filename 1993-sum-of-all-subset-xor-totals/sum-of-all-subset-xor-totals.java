class Solution {

    public int subsetXORSum(int[] nums) {
        int or = 0;
        for(int i = 0; i < nums.length; i++){
            or |= nums[i];
        }
        return or * (1 << (nums.length-1));
    }
}