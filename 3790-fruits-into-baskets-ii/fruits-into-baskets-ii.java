class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        // first rule: leftmoset in order basket[j] > fruits[i]
        // second rule: once used basket can't be used
        // third rule: if it is not possible to place then don't place
        int count =0;
        for(int i=0; i<fruits.length; i++){
            boolean flag = true;
            for(int j=0; j< baskets.length; j++){
                if(baskets[j] >= fruits[i]){
                    baskets[j] = 0;
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }

        return count;
        
    }
}