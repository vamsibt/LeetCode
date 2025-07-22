class Solution {
    public int myAtoi(String s) {
        int i=0;

        while(i<s.length() && s.charAt(i) == ' '){
            i++;
        }

        if(i==s.length()) return 0;

        long sign = 1;
        if( s.charAt(i) == '+' || s.charAt(i) == '-'){
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        long num =0;

        while( i<s.length() && Character.isDigit(s.charAt(i))){

            num = num*10+(s.charAt(i)-'0');
            i++;

            if (sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE; 
            if (sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            
        }

        num = num*sign;
        return (int)num;


    }
}