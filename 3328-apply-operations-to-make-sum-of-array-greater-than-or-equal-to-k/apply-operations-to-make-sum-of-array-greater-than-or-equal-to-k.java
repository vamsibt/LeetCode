class Solution {
    public int minOperations(int k) {
        int count =Integer.MAX_VALUE;
        if(k == 1){
            return 0;
        }
        for(int i=1; i<=Math.sqrt(k) ; i++){
            int ruleOneOp = i-1;
            int ruleTwoOp = (k+i-1)/i;
            count = Math.min(count, ruleOneOp+ruleTwoOp-1);
        }
        return count;
    }
}