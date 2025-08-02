class Solution {
    public void addToMap(Map<Integer, String> m, int[] val, String[] symbol){
        for(int i = 0; i < val.length; i++){
            m.put(val[i], symbol[i]);
        }
    }
    public String intToRoman(int num) {
        int[] val = {1, 5, 10, 50, 100, 500, 1000};
        String[] symbol = {"I", "V", "X", "L", "C", "D", "M"};
        Map<Integer, String> m = new HashMap<>();
        addToMap(m, val, symbol);
        String res = "";
        int digit = 0;
        while(num > 0){
            int rem = num % 10;
            int t = (int)Math.pow(10, digit);
            if(rem == 9){
                res = m.get(t) + m.get(t*10) + res; 
            } else if(rem == 4){
                res = m.get(t) + m.get(t*5) + res;
            } else if(rem < 4){
                String temp = "";
                while(rem > 0){
                    temp = temp + m.get(t);
                    rem--;
                }
                res = temp + res;
            } else{
                int start = 5;
                String temp = m.get(start * t);
                while(start < rem){
                    temp = temp + m.get(t);
                    start++;
                }
                res = temp + res;
            }
            digit++;
            num = num/10;
        }
        return res;
    }
}