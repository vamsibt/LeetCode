class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        // first rule: leftmoset in order basket[j] > fruits[i]
        // second rule: once used basket can't be used
        // third rule: if it is not possible to place then don't place
        boolean[] flag = new boolean[baskets.length];
        Arrays.fill(flag, true);
        int count =0;
        for(int i=0; i<fruits.length; i++){
            for(int j=0; j< baskets.length; j++){
                if(baskets[j] >= fruits[i] && flag[j]){
                    flag[j] = false;
                    count++;
                    break;
                }
            }
        }

        return baskets.length-count;
        
    }
}