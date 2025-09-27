class Solution {
    public long flowerGame(int n, int m) {
        long evenInN = n/2;
        long oddInN = n- evenInN;
        long evenInM = m/2;
        long oddInM = m - evenInM;
        long total = evenInN*oddInM + oddInN*evenInM;
        //even in first row and odd in second row

       

        //odd in first row and even in second row

        return total;
    }
}