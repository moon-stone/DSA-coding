class Solution {
    public boolean canWePlace(int m, int diff, int[] pos){
        int count = 1;
        int start = pos[0];
        for(int i = 1; i < pos.length; i++){
            if(pos[i] - start >= diff){
                count++;
                start = pos[i];
            }
        }
        return count >= m;
    }
    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int min = pos[0];
        int max = pos[pos.length - 1];
        int mid, start = 0, end = max, res = 0;
        while(start < end){
            mid = start + (end - start)/2;
            if(canWePlace(m, mid, pos)){
                start = mid + 1;
                res = Math.max(res, mid);
            }
            else{
                end = mid;
            }
        //    System.out.println(start+ " " + end +" "+mid);
        }
        return res;   
    }
}