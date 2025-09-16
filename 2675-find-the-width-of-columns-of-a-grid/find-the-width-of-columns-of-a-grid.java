class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] res = new int[n];

        for(int j=0; j<n; j++){
            int maxLength = 0;
            for(int i=0; i<m; i++){
                String a = String.valueOf(grid[i][j]);
                if(a.length() > maxLength){
                    maxLength = a.length();
                }
            }

            res[j] = maxLength;
        }

        return res;
    }
}