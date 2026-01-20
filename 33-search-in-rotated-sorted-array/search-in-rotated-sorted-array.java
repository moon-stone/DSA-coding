class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int res = -1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            System.out.println(mid+" "+start+" "+end+" ");
            if(target <= nums[end]){
                if(target < nums[mid] && nums[mid] <= nums[end]) end = mid;
                else start = mid+1;
            } else{
                if(target > nums[mid] && nums[mid] > nums[start]) start = mid+1;
                else end = mid;
            }
        }
        return nums[start] == target ? start : res;
    }
}