class NumArray {
    int[] num;
    public NumArray(int[] nums) {
        num = nums;
        for(int i = 1; i < nums.length; i++){
            num[i] = num[i] + num[i-1];
            System.out.println(num[i]+" ");
        }    
    }
    
    public int sumRange(int left, int right) {
        return left == 0 ? num[right] : num[right] - num[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */