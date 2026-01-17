class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            String temp = strs[i];
            int[] count = new int[26];
            String key = "";
            for(int j = 0; j < temp.length(); j++){
                count[(temp.charAt(j) -'a')]++;
            }
            for(int j = 0; j < 26; j++){
                char c = (char)('a'+j);
                key = key + count[j] + c;
                // System.out.print(count[j]+" ");
            }
            ArrayList<String> keyList = map.getOrDefault(key, new ArrayList<String>());
            keyList.add(temp);
            map.put(key, keyList);
        }
        for(String key : map.keySet()){
            // System.out.println(key + " " + map.get(key));
            res.add(map.get(key));
        }
        return res;
    }
}