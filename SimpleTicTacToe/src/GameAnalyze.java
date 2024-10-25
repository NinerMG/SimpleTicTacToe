public class GameAnalyze {


    public boolean gameAnalyze(char[][] grid) {
     return analyzeGameOver(grid);
    }

    private boolean analyzeGameOver(char[][] grid){

        if (!isValidGrid(grid)) {
            System.out.println("Impossible");
            return true;
        }else if(isWin(grid, 'X')){
            System.out.println("X wins");
            return true;
        } else if (isWin(grid, 'O')){
            System.out.println("O wins");
            return true;
        } else if (countMarks(grid) == 9) {
            System.out.println("Draw");
            return true;
        } else {
            return false;
        }

    }


    private boolean isGridFilled(char[][] grid){
        return countMarks(grid) == 9;
    }

    private boolean isWin(char[][] grid, char mark){

        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == mark && grid[i][1] == mark && grid[i][2] == mark) {
                return true;
            }
            if (grid[0][i] == mark && grid[1][i] == mark && grid[2][i] == mark){
                return true;
            }
            if (grid[0][0] == mark && grid[1][1] == mark && grid[2][2] == mark){
                return true;
            }
            if (grid[2][0] == mark && grid[1][1] == mark && grid[0][2] == mark){
                return true;
            }
        }
        return false;
    }

    private int countMarks(char[][] grid){
        return (countSingleMark(grid, 'X') + countSingleMark(grid, 'O'));
    }

    private int countSingleMark(char[][] grid, char mark){
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == mark){
                    count++;
                }
            }
        }
        return count;
    }
    private int marksNumberDifference(char[][] grid){
        return Math.abs(countSingleMark(grid, 'X') - countSingleMark(grid, 'O'));
    }

    private boolean isValidGrid(char[][] grid){

        if (isWin(grid, 'X') && isWin(grid, 'O')){
            return false;
        } else if (marksNumberDifference(grid) > 1){
            return false;
        }
        else {
        return true;
        }
    }
}
