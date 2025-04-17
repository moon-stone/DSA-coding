class Solution {
    long[] segTree;
    public void init(int n){
        segTree = new long[4*n];
    }
    public long buildSegTree(long[] segTree, int ind, int start, int end){
        if(ind < start || ind > end) return 0;
        if(start == end) return segTree[ind] = 0;
        int mid = start + (end - start)/2;
        long left = buildSegTree(segTree, 2*ind + 1, start, mid);
        long right = buildSegTree(segTree, 2*ind+2, mid+1, end);
        segTree[ind] = left+right;
        return segTree[ind];
    }
    public long updateST(long[] segTree, int ind, int start, int end, int i)  {
        if(start > i || end < i) return segTree[ind];
        if(start == end && start == i) {
            // System.out.println(start+" ");
            segTree[ind] = 1;
    //        System.out.println(start+" "+ind +" "+segTree[ind]+" ");
            return segTree[ind];
        }
        int mid = start + (end - start)/2;
        segTree[ind] = (long)updateST(segTree, ind*2+1, start, mid, i) +
                updateST(segTree, ind*2+2, mid+1, end, i);
    //    System.out.println(start+" "+end+" "+ind+" "+segTree[ind]);
        return segTree[ind];
    }
    public long matchedNums(long[] segTree, int ind, int start, int end, int l, int r){
        if(start > r || end < l || start > end) return 0;
        if(start >= l && end <= r) {
        //    System.out.println(start + " "+end+" "+l+" "+r+" "+ind+" "+segTree[ind]);
            return segTree[ind];
        }
    //    if(r == 0) System.out.println("match" + ind+" "+start+" "+end+" "+l+" "+r);
    //    if(start == l && r == end) return segTree[ind];
        int mid = start + (end - start)/2;
        return segTree[ind] = (long)matchedNums(segTree, ind*2 + 1, start, mid, l, r) + matchedNums(segTree, ind*2 + 2, mid+1, end, l, r);
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        init(nums2.length);
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }
        buildSegTree(segTree, 0, 0, nums2.length - 1);
        int ind = map.get(nums1[0]);
        updateST(segTree, 0, 0, nums2.length-1, ind);
        for(int i = 1; i < nums1.length; i++){
            int ri = map.get(nums1[i]);
            long leftMatch2ndArray = matchedNums(segTree, 0, 0, nums2.length-1, 0, ri-1);
            long notLeftMatch1stArray = (i - leftMatch2ndArray);
            long rightMatch2ndArray = (nums2.length - (ri + 1) - notLeftMatch1stArray);
            res = res + (leftMatch2ndArray * rightMatch2ndArray);
    //        System.out.println("main "+nums1[i] + " "+ri +" "+leftMatch2ndArray);
            updateST(segTree, 0, 0, nums2.length-1, ri);
        }
        return res;
    }
}

        // 1 2 3 4 5 6 7 8 9
        // 3 4 5 6 7 8 9 1 2 