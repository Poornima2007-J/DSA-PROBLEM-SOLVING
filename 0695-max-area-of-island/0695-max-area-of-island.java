class Solution {
    int maxArea;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.maxArea = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        boolean[][] visited = new boolean[row][col];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int[] area = new int[]{0}; 
                    dfs(i, j, grid, visited, area);
                }
            }
        }
        return this.maxArea;
    }
    
    public void dfs(int r, int c, int[][] grid, boolean[][] visited, int[] area) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;
        if (visited[r][c]) return;
        if (grid[r][c] == 0) return;

        visited[r][c] = true;
        area[0]++; 
        
        this.maxArea = Math.max(this.maxArea, area[0]);

        dfs(r + 1, c, grid, visited, area);
        dfs(r - 1, c, grid, visited, area);
        dfs(r, c + 1, grid, visited, area);
        dfs(r, c - 1, grid, visited, area);
    }
}
