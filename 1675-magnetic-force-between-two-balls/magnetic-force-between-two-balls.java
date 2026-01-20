class Solution {
    public int countBalls(int[] pos, int dist){
        int prev = pos[0];
        int count = 1;
        int ind = 1;
        while(ind < pos.length){
            if(pos[ind] - prev >= dist){
                prev = pos[ind];
                count++;
            }
            ind++;
        }
        return count;
    }
    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int start = 0, end = pos[pos.length - 1];
        int res = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(countBalls(pos, mid) >= m){
                start = mid+1;
                res = Math.max(res, mid);
            } else end = mid - 1;
        }
        return res;
    }
}