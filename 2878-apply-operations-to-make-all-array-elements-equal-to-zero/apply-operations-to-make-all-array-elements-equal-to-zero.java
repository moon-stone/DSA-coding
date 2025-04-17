class Solution {
    public boolean checkArray(int[] nums, int k) {
        //we will solve this using diff array where we will create a 
        //diff array of which we try to maintain the final preSum as zero
        int[] diff = new int[nums.length+1];
        diff[0] = nums[0];
        diff[k] -= nums[0];
        for(int i = 1; i < nums.length; i++){
            diff[i] += diff[i-1];
            if(diff[i] == nums[i]) continue;
            if(nums[i] < diff[i]) return false;
            //below condition will hit when nums[i] > diff[i] & we can't make them zero
            if(i+k-1 >= nums.length) return false;
            int diffValue = nums[i] - diff[i];
            diff[i] += diffValue;
            diff[i+k] -= diffValue;
        }
        return true;
    }
}