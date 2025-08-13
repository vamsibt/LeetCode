class Solution {
    public void solve(char[][] board) {
        

        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m;j++){
                HashSet<int[]> set = new HashSet<>();
                if(!visited[i][j] && board[i][j] == 'O'){
                    dfs(visited, board, set, i, j);
                    boolean flag = true;
                    for(int[] arr : set){
                        if(arr[0] == 0 || arr[0] == n-1 || arr[1] == 0 || arr[1] == m-1){
                            flag = false;
                            break;
                        }
                    }

                    if(flag == true){
                        for(int[] arr : set){
                            board[arr[0]][arr[1]] = 'X';
                        }
                    }
                }
            }
        }
    }


    public void dfs(boolean[][] visited, char[][] board, HashSet<int[]> set, int i, int j){
        if(visited[i][j] == true){
            return;
        }
        visited[i][j] = true;
        int[] arr = new int[2];
        arr[0]= i;
        arr[1] = j;
        set.add(arr);
        //right
        if(j<board[0].length-1 && board[i][j+1] == 'O'){
           dfs(visited, board, set, i, j+1);
        }
        //left
        if(j>0 && board[i][j-1] == 'O'){
            dfs(visited, board, set, i, j-1);
        }
        //top
        if(i>0 && board[i-1][j] == 'O'){
            dfs(visited, board, set, i-1, j);
        }
        //bottom
        if(i<board.length-1 && board[i+1][j] == 'O'){
            dfs(visited, board, set, i+1, j);
        }
    }
}