class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int left_min = nums[0];
        int curr = -1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > left_min){
                if(curr != -1 && nums[curr] < nums[i]) return true;
                if(curr == -1 || nums[curr] > nums[i]) curr = i;
            }else{
                left_min = nums[i];
            }
        }
        return false;    
    }
}