class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(count[i] > 0) pq.add(new int[]{count[i], i});
        }
        String res = "";
        // System.out.println(pq.size());
        while(!pq.isEmpty()){
            int[] temp1 = pq.poll();
            int[] temp2 = pq.size() >= 1 ? pq.poll() : new int[]{-1, -1};
            char t1 = (char)('a' + temp1[1]);
            temp1[0]--;
            res = res + t1;
            if(temp2[1] != -1){
                char t2 = (char)('a' + temp2[1]);
                res = res + t2;
                temp2[0]--;
            }
            if(temp1[0] > 1 && pq.isEmpty() && temp2[0] < 1) return "";
            if(temp1[0] > 0) pq.add(temp1);
            if(temp2[0] > 0) pq.add(temp2);
        }
        return res;
    }
}