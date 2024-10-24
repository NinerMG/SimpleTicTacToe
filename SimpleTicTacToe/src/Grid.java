public class Grid {

    public char[][] grid = new char[3][3];
    private static Grid instance;

    public static Grid getInstance(String input) {
        if (instance == null) {
            synchronized (Grid.class) {
                if (instance == null) {
                    instance = new Grid(input);
                }
            }
        }
        return instance;
    }

    private Grid(String input){
        gridDrawFromInput(stringInputToGrid(input));
        //GameAnalyze gameAnalyze = new GameAnalyze();
        //gameAnalyze.gameAnalyze(grid);

    }
    private char[] stringInputToGrid(String inputString){
        return inputString.toCharArray();
    }

    private void gridDrawFromInput(char[] inputChar){
      fillGridWithInput(inputChar);
      gridDraw();
    }

    public void gridDraw(){
        drawBorder();
        for(int i = 0; i < grid.length; i++){
            drawRow(i);
        }
        drawBorder();
    }

    private void fillGridWithInput(char[] inputChar){
        int charSpot = 0;

        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                grid[i][j] = inputChar[charSpot];
                charSpot++;
            }
        }
    }
    private void drawRow(int rowIndex){
        System.out.print("| ");
        for (int i = 0; i < grid[rowIndex].length; i++){
            System.out.print(grid[rowIndex][i] + " ");
        }
        System.out.println("|");
    }
    private void drawBorder(){
        System.out.println("---------");
    }
}
