public class GameAnalyze {


    public void gameAnalyze(char[][] grid) {
        if (!isGridFilled(grid)){
            System.out.println("Game not finished");
        }
    }


    private boolean isGridFilled(char[][] grid){
        int count = 0;
        for (char[] chars : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (chars[j] == 'X' || chars[j] == 'O') {
                    count++;
                }
            }
        }
        return (count == 9);
    }
}
