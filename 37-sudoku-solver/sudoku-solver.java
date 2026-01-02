class Solution {
    public boolean checkRow(char[][] board, int row, int num){
        for(int i = 0; i < 9; i++){
            if(board[row][i] - '0'== num) return false;
        }
        return true;
    }
    public boolean checkCol(char[][] board, int col, int num){
        for(int i = 0; i < 9; i++){
            if(board[i][col] - '0' == num) return false;
        }
        return true;
    }
    public boolean checkSubBox(char[][] board, int row, int col, int num){
        int row_mod = 3 * (row/3); 
        int col_mod = 3 * (col/3);
        // System.out.println(row +" "+col+" "+row_mod+" "+col_mod);
        for(int i = row_mod; i < row_mod+3; i++){
            for(int j = col_mod; j < col_mod+3; j++){
                // System.out.print(i + " "+j+" ");
                if(board[i][j] - '0' == num) return false;
            }
            // System.out.println();
        }
        return true;
    }
    public boolean SudokuSolver(char[][] board, int row, int col){
        if(row >= 8 && col >= 9) return true;
        if(col >= 9) {
            // System.out.println(row +" "+col);
            return SudokuSolver(board, row+1, 0);}
        // if(row >= 9 || col >= 9) return true;
        
        if(board[row][col] != '.'){
            return SudokuSolver(board, row, col + 1);
        }
        for(int i = 1; i <= 9; i++){
            if(checkRow(board, row, i) && checkCol(board, col, i) && checkSubBox(board, row, col, i)){
                board[row][col] = (char)('0' + i);
                // System.out.println(board[row][col] + " "+row+" "+col);
                if(SudokuSolver(board, row, col+1)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        SudokuSolver(board, 0, 0);
    }
}