// class Solution {
//     public int numIslands(char[][] grid) {
//         int count =0;
//         for(int i=0; i<grid.length; i++){
//             for(int j =0; j<grid[0].length; j++){
//                 if(grid[i][j] == '1'){
//                     count++;
//                     dfs(i,j, grid);
//                 }
//             }
//         }
//         return count;
//     }

//     public void dfs(int i, int j, char[][] grid){
//         grid[i][j] = '0';

//         if( i-1>=0 && grid[i-1][j] == '1'){
//             dfs(i-1, j, grid);
//         }
//         if(j+1< grid[0].length && grid[i][j+1] == '1'){
//             dfs(i,j+1, grid);
//         }
//         if(i+1< grid.length && grid[i+1][j] == '1'){
//             dfs(i+1, j, grid);
//         }
//         if(j-1>=0 && grid[i][j-1] == '1'){
//             dfs(i, j-1, grid);
//         }
//     }
// }


class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] visited = new boolean [n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid, visited, i,j);
                    count++;
                }
               
            }
        }

        return count;
    }

    public void dfs(char[][] grid,boolean[][] visited, int i, int j){
        if(visited[i][j] == true){
            return;
        }
        visited[i][j] = true;
        //right
        if(j<grid[0].length-1 && grid[i][j+1] == '1'){
            dfs(grid, visited, i, j+1);
        }
        //left
        if(j>0 && grid[i][j-1] == '1'){
            dfs(grid, visited, i, j-1);
        }
        //top
        if(i>0 && grid[i-1][j] == '1'){
            dfs(grid, visited, i-1, j);
        }
        //bottom
        if(i<grid.length-1 && grid[i+1][j] == '1'){
            dfs(grid, visited, i+1, j);
        }
    }
}