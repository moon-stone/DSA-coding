class Solution {
    public boolean search(int[] nums, int target) {
        boolean res = false;
        int start = 0, end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return true;
            // System.out.println(mid+" "+start+" "+end+" ");
            if(nums[mid] == nums[end] && nums[mid] == nums[start]){
                start++;
                end--;
                continue;
            }
            if(target <= nums[end]){
                if(nums[mid] <= nums[end] && nums[mid] >= target) end = mid;
                else start = mid+1;
            }
            else{
                if(nums[mid] >= nums[start] && nums[mid] <= target) start = mid+1;
                else end = mid;
            }
        }
        return nums[start] == target ? true : false;
    }
}