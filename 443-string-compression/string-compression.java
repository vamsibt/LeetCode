class Solution {
    public int compress(char[] chars) {

        int x =0;
        String a =new String();
        int count =1;

        if(chars.length == 1){
            a +=chars[0];
            return 1;
        }

        for(int i=1; i<chars.length; i++){
            if(chars[x] == chars[i]){
                count++;
            }else{
                a +=chars[x];
                if(count>1){
                    a += Integer.toString(count);
                    count =1;
                }
                x = i;

            }
        }
        a +=chars[x];
        if(count>1){
            a += Integer.toString(count);
        }

        for(int i=0; i<a.length(); i++){
            chars[i] = a.charAt(i);
        }

        return a.length();
    }
}