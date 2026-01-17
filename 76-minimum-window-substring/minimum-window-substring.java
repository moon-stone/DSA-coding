class Solution {
    public boolean compare(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] < b[i]) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int[] tdp = new int[70];
        int[] sdp = new int[70];
        for(int i = 0; i < t.length(); i++){
            tdp[t.charAt(i) - 'A']++;
            sdp[s.charAt(i) - 'A']++;
        }
        int start = 0, end = t.length()-1, start_res = -1, end_res = 0;
        int res = Integer.MAX_VALUE;
        while(end < s.length() && start < s.length()){
            if(compare(sdp, tdp)){
                // System.out.println(start+" "+end);
                if(res > (end - start + 1)){
                    start_res = start;
                    end_res = end;
                    res = end - start + 1;
                }
                sdp[s.charAt(start) - 'A']--;
                start++;
                continue;
            }
            end++;
            if(end < s.length()) sdp[s.charAt(end) - 'A']++;
        }
        if(start_res == -1) return "";
        return s.substring(start_res, end_res+1);
    }
}