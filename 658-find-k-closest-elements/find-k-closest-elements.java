class Pair{
    int num;
    int diff;
    public Pair(int num, int diff){
        this.num = num;
        this.diff = diff;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>(); 
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.diff == b.diff) return b.num - a.num;
            return b.diff - a.diff;
        });
        for(int i = 0; i < k; i++){
            pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
        }
        for(int i = k; i < arr.length; i++){
            Pair top = pq.peek();
            if(top.diff > Math.abs(arr[i] - x)){
                pq.poll();
                pq.add(new Pair(arr[i], Math.abs(arr[i]-x)));
            }
        }
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            res.add(top.num);
        }
        res.sort((a, b) -> a - b);
        return res;
    }
}