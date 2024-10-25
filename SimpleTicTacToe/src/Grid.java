import java.util.Arrays;

public class Grid {

    public char[][] grid = new char[3][3];
    private static Grid instance;

    public static Grid getInstance() {
        if (instance == null) {
            synchronized (Grid.class) {
                if (instance == null) {
                    instance = new Grid();
                }
            }
        }
        return instance;
    }

    private Grid(){
        fillGridWithInput();
        gridDraw();
    }

    public void gridDraw(){
        drawBorder();
        for(int i = 0; i < grid.length; i++){
            drawRow(i);
        }
        drawBorder();
    }

    private void fillGridWithInput(){
        for (char[] chars : grid) {
            Arrays.fill(chars, ' ');
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
