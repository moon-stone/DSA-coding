class Solution {
    public void setZeroForRow(int[][] matrix, int row){
        for(int i = 0; i < matrix[0].length; i++){
            matrix[row][i] = 0;
        }
    }

    public void setZeroForCol(int[][] matrix, int col){
        for(int i = 0; i < matrix.length; i++){
            matrix[i][col] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {
        int first_row = 0, first_col = 0;
        int col = matrix[0].length;
        int row = matrix.length;
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                first_row = 1;
            }
        }
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                first_col = 1;
            }
        }
        for(int i = row-1; i > 0; i--){
            for(int j = col-1; j > 0; j--){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // System.out.println(row +" "+col);
        // for(int i = 0; i < matrix.length; i++){
        //     for(int j = 0; j < matrix[0].length; j++){
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                setZeroForCol(matrix, i);
            }
        }
        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                setZeroForRow(matrix, i);
            }
        }
        if(first_row == 1){
            setZeroForRow(matrix, 0);
        }
        if(first_col == 1){
            setZeroForCol(matrix, 0);
        }
    }
}