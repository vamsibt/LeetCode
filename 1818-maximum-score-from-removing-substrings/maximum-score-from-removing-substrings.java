class Solution {
    // int result = 0;
    // public int maximumGain(String s, int x, int y) {
    //     recursion(s, x,y, 0, "ab", "ba");
    //     return result;

    // }

    // public void recursion(String s, int x, int y, int local, String ab, String ba){
    //     result = Math.max(result, local);
    //     for(int i=0; i<s.length()-1; i++){
    //         String st = s.substring(i, i+2);
    //         if(st.equals(ab)){
    //             recursion(s.substring(0,i)+s.substring(i+2), x,y,  local+x, ab, ba);
    //         }
    //         if(st.equals(ba)){
    //             recursion(s.substring(0,i)+s.substring(i+2), x, y,local+y, ab, ba);
    //         }
    //     }
    // }

    public int maximumGain(String s, int x, int y) {
        if(y>x){
            return maximum(s, y,x, "ba", "ab");
        } else{
            return maximum(s, x,y, "ab", "ba");
        }
       
    }

    public int maximum(String s, int high, int low, String highpair, String lowpair){
        Stack<Character> st = new Stack<>();
        int score =0;
        for(char c: s.toCharArray()){
            if(!st.isEmpty() && (st.peek() == highpair.charAt(0) && c == highpair.charAt(1))){
                st.pop();
                score += high;
            } else{
                st.push(c);
            }
        }

        Stack<Character> st2 = new Stack<>();
        while(!st.isEmpty()){
            char c = st.pop();
            if(!st2.isEmpty() &&(st2.peek()== lowpair.charAt(1) && c == lowpair.charAt(0))){
                st2.pop();
                score +=low;
            } else{
                st2.push(c);
            }
        }
        return score;
    }
}