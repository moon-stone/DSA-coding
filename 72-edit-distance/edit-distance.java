class Solution {
    public int findDist(int[][] dp, int i, int j, String word1, String word2){
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = findDist(dp, i-1, j-1, word1, word2);
        } else{
            dp[i][j] = 1 + Math.min(findDist(dp, i-1, j, word1, word2), Math.min(findDist(dp, i, j-1, word1, word2), findDist(dp, i-1, j-1, word1, word2)));
        }
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i = 0; i < word1.length(); i++){
            for(int j = 0; j < word2.length(); j++){
                dp[i][j] = -1;
            }
        }
        return findDist(dp, word1.length()-1, word2.length()-1, word1, word2);
    }
}