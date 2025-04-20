class Solution {
    public boolean isZeroArray(int[] nums, int[][] que) {
        int[] buff = new int[100002];
        for(int i = 0; i < que.length; i++){
            int l = que[i][0];
            int r = que[i][1];
            buff[l]--;
            buff[r+1]++;
        }
        int val = 0;
        for(int i = 0; i < nums.length; i++){
            val += buff[i];
            if(val + nums[i] > 0) return false;
        }
        return true;
    }
}