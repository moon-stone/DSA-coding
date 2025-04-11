class Solution {
    public int countDigit(int n){
        int count = 0;
        while(n > 0){
            n /= 10;
            count++;
        }
        return count;
    }
    public int sumDigit(int n, int start, int end){
        int count = 0, sum = 0;
        while(n > 0){
            if(count >= start && count <= end) sum += (n%10);
            n /= 10;
            count++;
        }
        return sum;
    }
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for(int i = low; i <= high; i++){
            int digits = countDigit(i);
            if((digits & 1) == 1) continue;
            int ind = digits/2;
            if(sumDigit(i, 0, ind-1) == sumDigit(i, ind, digits-1)) res++;
        }
        return res;
    }
}