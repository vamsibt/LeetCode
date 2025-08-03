class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();

        boolean [] flag = new boolean[n];
        Arrays.fill(flag, true);

        Queue<Integer> Ridx = new LinkedList<>();
        Queue<Integer> Didx = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            char ch = senate.charAt(i);
            if(ch == 'R'){
                Ridx.add(i);
            } else{
                Didx.add(i);
            }
        }

        while(!Ridx.isEmpty() && !Didx.isEmpty()){
            int r = Ridx.poll();
            int d = Didx.poll();

            if(r<d){
                Ridx.add(r+n);
            } else{
                Didx.add(d+n);
            }
        }

        if(Ridx.isEmpty()){
            return "Dire";
        } else{
            return "Radiant";
        }
        
    }
}