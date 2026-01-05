class Pair{
    String s;
    int count;
    public Pair(String s, int count){
        this.s = s;
        this.count = count;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Set<String> set = new HashSet<>();
       Map<String, Integer> map = new HashMap<>();
       Queue<Pair> q = new ArrayDeque<>();
       for(String s : wordList){
        set.add(s);
       }
       if(!set.contains(endWord)) return 0;
       q.add(new Pair(beginWord, 1));
       map.put(beginWord, 1);
       while(!q.isEmpty()){
        Pair p = q.poll();
        String word = p.s;
        int count = p.count;
        if(p.s.equals(endWord)) return p.count;
        for(int i = 0; i < endWord.length(); i++){
            for(int j = 0; j < 26; j++){
                char c = (char)('a' + j);
                String temp = word.substring(0, i)  + c + word.substring(i+1);
                if(!map.containsKey(temp) && set.contains(temp)){
                    map.put(temp, count+1);
                    q.add(new Pair(temp, count+1));
                }
            }
        }
       }
       return 0;
    }
}