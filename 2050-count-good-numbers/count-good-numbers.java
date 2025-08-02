class Solution {
    long mod =1_000_000_007;
    public int countGoodNumbers(long n) {
        if(n == 1){
            return 5;
        }
        long even_count = (n+1)/2;
        long odd_count = (n/2);
        
        long answer = pow(5, even_count)*pow(4, odd_count);
        

        return (int)(answer% mod);
    }

    public long pow(long val, long count){
       long result =1;
       val %=mod;

       while(count > 0){
        if((count & 1) == 1 ) result = (result*val)% mod;
        val = (val*val)%mod;
        count >>=1;
       }
       return (int) result;
    }
}