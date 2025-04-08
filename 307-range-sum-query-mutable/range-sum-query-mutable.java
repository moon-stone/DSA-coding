class NumArray {
    class SegTree{
        int val;
        int start;
        int end;
        SegTree left;
        SegTree right;
        public SegTree(int start, int end){
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.val = 0;
        }
    }
    SegTree root = null;
    private SegTree buildST(int[] nums, int i, int j){
        if(i > j) return null;
        SegTree rt = new SegTree(i, j);
        if(i == j) {
            rt.val = nums[i];
            return rt;
        }
        int mid = i + (j - i)/2;
        rt.left = buildST(nums, i, mid);
        rt.right = buildST(nums, mid+1, j);
        rt.val = rt.left.val + rt.right.val;
        return rt;
    }
    private void updateST(SegTree root, int index, int val){
        if(root.left == root.right){
            root.val = val;
            return;
        }
        int mid = root.start + (root.end - root.start)/2;
        if(index > mid){
            updateST(root.right, index, val);
        }else{
            updateST(root.left, index, val);
        }
        root.val = root.left.val + root.right.val;
    }
    private int rangeSumST(SegTree root, int i, int j){
        if(root.start == i && root.end == j) {
        //    System.out.println(root.val+" "+i + " "+j);
            return root.val;
        }
        if(i > root.end || j < root.start) return 0;
        int mid = root.start + (root.end - root.start)/2;
        if(j <= mid) return rangeSumST(root.left, i, j);
        else if(i > mid) return rangeSumST(root.right, i, j);
        return rangeSumST(root.left, i, mid) + rangeSumST(root.right, mid+1, j);
    }
    public NumArray(int[] nums) {
        root = buildST(nums, 0, nums.length - 1);
    }
    
    public void update(int index, int val) {
        updateST(root, index, val);
    }
    
    public int sumRange(int left, int right) {
        return rangeSumST(root, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */