class Solution {
    public int[][] merge(int[][] inter) {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        Arrays.sort(inter, (a, b) -> a[0] - b[0]);
        int start = inter[0][0], end = inter[0][1];
        int ind = 1;
        while(ind < inter.length){
            if(end >= inter[ind][0]){
                end = Math.max(inter[ind][1], end);
                ind++;
                continue;
            }
            temp.add(new ArrayList<>(List.of(start, end)));
            start = inter[ind][0];
            end = inter[ind][1];
            ind++;
        }
        temp.add(new ArrayList<>(List.of(start, end)));
        int[][] res = new int[temp.size()][2];
        for(int i = 0; i < temp.size(); i++){
            res[i][0] = temp.get(i).get(0);
            res[i][1] = temp.get(i).get(1);
        }
        return res;


    }
}