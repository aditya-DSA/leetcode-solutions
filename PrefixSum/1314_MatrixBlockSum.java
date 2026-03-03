class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        //row length
        int m = mat.length;
        //column length
        int n = mat[0].length;
        //take prefix with extra row and column
        //as we use here take more area and delete the unwanted thing
        int[][] prefix = new int[m+1][n+1];
        //intially prefix matrix is 0's find the prefix matrix
        //iterate the matrix
        for(int i =1;i<=m;i++){
            for(int j= 1;j<=n;j++){
                prefix[i][j] = mat[i-1][j-1]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];
            }
        }
        //now calculate the result
        int[][] result = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++) {
                int r1 = Math.max(0,i-k);
                int c1 = Math.max(0,j-k);
                int r2 = Math.min(m-1,i+k);
                int c2 = Math.min(n-1,j+k);
                r1++;
                c1++;
                r2++;
                c2++;
                result[i][j] = prefix[r2][c2]-prefix[r1-1][c2]-prefix[r2][c1-1]+prefix[r1-1][c1-1];
            }
        }
        return result;
    }
}