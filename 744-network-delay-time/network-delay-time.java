class Solution {
    class Pair{
        int node;
        int wt;
        public Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> gh = new ArrayList<>();
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int[] visited = new int[n+1];
        int[] dist = new int[n+1];
        int res = -1;
        for(int i = 0; i <= n; i++){
            gh.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < times.length; i++){
            int startNode = times[i][0];
            int endNode = times[i][1];
            int wt = times[i][2];
            gh.get(startNode).add(new Pair(endNode, wt));
        }
        for(int i = 1; i < n+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        visited[k] = 1;
        dist[k] = 0;
        pq.add(new int[]{0, k});
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int node = temp[1];
            int distance = temp[0];
            visited[node] = 1;
            for(int i = 0; i < gh.get(node).size(); i++){
                Pair p = gh.get(node).get(i);
                int tot_dist = distance + p.wt;
                if(dist[p.node] > tot_dist){
                    pq.add(new int[]{tot_dist, p.node});
                    dist[p.node] = tot_dist;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(visited[i] == 0) return -1; 
            res = Math.max(res, dist[i]);
        //    System.out.println(i + " "+dist[i]+" ");
        }
        return res;
    }
}