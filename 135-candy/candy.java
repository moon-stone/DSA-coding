class Solution {
    public int candy(int[] ratings) {
        // i   , i-1 < i && i > i+1
        //       i-1 < i || i > i+1
        //     1 2 3 4 5 6 1 2 3 4 5 6
        //     1 2 3        1 2
        int[][] pairs = new int[ratings.length][2];
        int[] candies = new int[ratings.length];
        if(ratings.length == 1) return 1;
        for(int i = 0; i < ratings.length; i++){
            pairs[i] = new int[]{ratings[i], i};
        }
        Arrays.sort(pairs, (a, b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0] - b[0];
        });
        for(int i = 0; i < pairs.length; i++){
            int val = pairs[i][0];
            int ind = pairs[i][1];
            if(ind == 0){
                if(ratings[ind+1] < ratings[ind]) candies[ind] = candies[ind+1]+1;
                else candies[ind] = 1;
                continue;
            }
            if(ind == ratings.length - 1){
                if(ratings[ind] > ratings[ind-1]) candies[ind] = candies[ind-1]+1;
                else candies[ind] = 1;
                continue;
            }
            if(ratings[ind] > ratings[ind-1] && ratings[ind] > ratings[ind+1]){
                candies[ind] = Math.max(candies[ind+1], candies[ind-1]) + 1;
            }
            else if(ratings[ind] > ratings[ind-1]) candies[ind] = candies[ind-1]+1;
            else if(ratings[ind] > ratings[ind+1]) candies[ind] = candies[ind+1]+1;
            else candies[ind] = 1;

        //    System.out.println(ind+" "+candies[ind]);
        }
        int res = 0;
        for(int candy : candies) {
        //    System.out.println(candy+" ");
            res += candy;
        }
        return res; 
             
    }
}