class Solution {
    public int minimumArea(int[][] grid) {
        int left =0;
        int right =0;
        int top =0;
        int bottom =0;

        int rows = grid.length;
        int columns = grid[0].length;
        //left boundary
        for(int j=0; j<columns; j++){
            boolean flag = false;
            for(int i=0; i<rows; i++){
                if(grid[i][j] == 1){
                    left = j;
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }


        //right boundary
        for(int j=columns-1; j>=0; j--){
            boolean flag = false;
            for(int i=0; i<rows; i++){
                if(grid[i][j] == 1){
                    right = j;
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        //Top boundary
        for(int i =0; i<rows; i++){
            boolean flag = false;
            for(int j=0; j<columns; j++){
                if(grid[i][j] == 1){
                    top = i;
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        //bottom boundary
        for(int i=rows-1; i>=0; i--){
             boolean flag = false;
            for(int j=0; j<columns; j++){
                if(grid[i][j] == 1){
                    bottom = i;
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        int totalArea = (bottom-top+1)*(right-left+1);

        return totalArea;
    }
}