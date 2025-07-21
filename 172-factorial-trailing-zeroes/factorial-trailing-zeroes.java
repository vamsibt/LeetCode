class Solution {
    public int trailingZeroes(int n) {
        // int fives=0;
        // int twos = 0;

        // for(int i=1; i<=n; i++){
        //     int num =i;
        //     if(num%2 == 0){
        //         twos++;
        //         num /=2;
        //         while(num>1){
        //             if(num%2 == 0) twos++;
        //             num /=2;
        //         }
        //     }
        //     num = i;
        //     if(num%5 == 0){
        //         fives++;
        //         num /=5;
        //         while(num >1){
        //             if(num%5 == 0) fives++;
        //             num /=5;
        //         }
        //     }
        // }

        // return Math.min(fives, twos);

        // In first 10 numbers there are 2 multiples of 5 nut more multiples of 2
        // so count = np.of 5 multiples
        // in first 10 nums 5 multiples is 2 which is equal to 10/5;


        int count=0;

        while(n>0){
            n /= 5;
            count += n;
        }

        return count;
    }
}