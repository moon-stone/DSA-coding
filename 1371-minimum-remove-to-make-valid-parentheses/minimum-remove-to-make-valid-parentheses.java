class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') st.push(i);
            if(s.charAt(i) == ')'){
                if(st.empty()) st.push(i);
                else if(s.charAt(st.peek()) == '(') st.pop();
                else if(s.charAt(st.peek()) == ')') st.push(i);
            }
        }
        while(!st.empty()){
            set.add(st.peek());
            st.pop();
        }
        for(int i = 0; i < s.length(); i++){
            if(!set.contains(i)) str.append(s.charAt(i));
        }
        return str.toString();
    }
}