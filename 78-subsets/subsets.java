class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for(int i = nums.length-1; i >= 0; i--){
            Set<List<Integer>> temp = new HashSet<>();
            ArrayList<Integer> temp_arr = new ArrayList<>();
            temp_arr.add(nums[i]);
            temp.add(temp_arr);
            for(List<Integer> list : set){
                temp.add(list);
                List<Integer> t = new ArrayList<>(list);
                list.add(nums[i]);
                temp.add(list);
                temp.add(t);
            }
            set.clear();
            set.addAll(temp);
            temp.clear();
        }
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> list : set){
            res.add(list);
        }
        res.add(new ArrayList<>());
        return res;
    }
}