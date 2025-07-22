class Solution {
    public int monkeyMove(int n) {
        long mod = (long)1e9+7;

        long result =1;
        long m = 2;
        while(n> 0){
            if(n%2 == 1){
                result = (result*m)%mod;
            }
            m = (m*m)%mod;
            n >>= 1;
        }

        return (int)((result-2+mod)%mod);
    }
}