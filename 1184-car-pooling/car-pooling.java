class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[][] dp = new int[n*2][3];
        boolean res = true;
        int curr_cap = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            dp[j++] = new int[]{trips[i][1], trips[i][0], 1};
            dp[j++] = new int[]{trips[i][2], trips[i][0], -1};
        }
        Arrays.sort(dp, (a,b) -> {
            if(a[0] == b[0]) return a[2] - b[2];
            return a[0] - b[0];
        });
        for(int i = 0; i < dp.length; i++){
            if(dp[i][2] == 1) curr_cap += dp[i][1];
    //        System.out.println(dp[i][0]+" "+dp[i][1]+" "+dp[i][2]);
            if(curr_cap > capacity) return false;
            if(dp[i][2] == -1) curr_cap -= dp[i][1];
        }
        return true;
    }
}