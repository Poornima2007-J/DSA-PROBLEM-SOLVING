class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org = image[sr][sc];
        if (org == color) return image;
        dfs(sr, sc, image, color, org);
        return image;
    }
    private void dfs(int row, int col, int[][] image, int color, int org) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) return;
        if (image[row][col] != org) return;
        image[row][col] = color;
        dfs(row + 1, col, image, color, org);
        dfs(row - 1, col, image, color, org);
        dfs(row, col + 1, image, color, org);
        dfs(row, col - 1, image, color, org);
    }
}
