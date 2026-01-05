class Solution {
    public boolean canFinish(int n, int[][] pre) {
        int[] indegree = new int[n];
        ArrayList<ArrayList<Integer>> gh = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean res = true;
        for(int i = 0; i < n; i++){
            gh.add(new ArrayList<>());
        }
        for(int i = 0; i < pre.length; i++){
            int start = pre[i][1];
            int end = pre[i][0];
            indegree[end]++;
            gh.get(start).add(end);
        }
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            List<Integer> temp = gh.get(node);
            for(int i = 0; i < temp.size(); i++){
                indegree[temp.get(i)]--;
                if(indegree[temp.get(i)] == 0) q.add(temp.get(i));
            }
        }
        for(int num : indegree){
            if(num != 0) return false;
        }
        return true;
    }
}