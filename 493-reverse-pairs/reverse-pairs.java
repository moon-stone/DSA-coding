class Solution {
    int count = 0;
    public int[] merge(int[] left, int[] right){
        ArrayList<Integer> res = new ArrayList<>();
        int ind1 = 0, ind2 = 0;
        while(ind1 < left.length && ind2 < right.length){
            if((long)left[ind1] > (long)2*right[ind2]) {
                count+= (left.length - ind1);
                ind2++;
            }
            else ind1++;
        }
        ind1 = 0; ind2 = 0;
        while(ind1 < left.length && ind2 < right.length){
            if(left[ind1] <= right[ind2]) res.add(left[ind1++]);
            else res.add(right[ind2++]);
        }
        while(ind1 < left.length) res.add(left[ind1++]);
        while(ind2 < right.length) res.add(right[ind2++]);
        int[] ret = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ret[i] = res.get(i);
        }
        return ret;
    }
    public int[] mergeSort(int[] nums, int start, int end){
        if(start == end) return new int[]{nums[start]};
        int mid = start + (end - start)/2;
        int[] left = mergeSort(nums, start, mid);
        int[] right = mergeSort(nums, mid+1, end);
        return merge(left, right);
    }
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0 , nums.length-1);
        return count;
    }
}