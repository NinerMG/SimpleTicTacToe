import java.util.Scanner;

public class UserInput {

    int x;
    int y;
    Grid grid; //grid 3x3

    public UserInput(String input){
        grid = Grid.getInstance(input);
        readNumbers();
        placeMark();
    }

    private void readNumbers() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            if (parseNumbers(parts)) {
                if (isValidCoordinates(x) || isValidCoordinates(y)) {
                    break;
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            }
        }
    }

    private boolean parseNumbers(String[] parts) {
        try {
            x = Integer.parseInt(parts[0]);
            y = Integer.parseInt(parts[1]);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You should enter two numbers!");
            return false;
        }

    }
    private boolean isValidCoordinates(int value) {
        return value > 0 && value < 4;
    }

    private void updateCoordinates(){
        x -=1;
        y -=1;
    }

    private void placeMark(){
        updateCoordinates();
        if (isPlaceValid()) {
            System.out.println("This cell is occupied! Choose another one!");
            readNumbers();
            placeMark();
        } else {
            grid.grid[x][y] = 'X';
            grid.gridDraw();
        }
    }

    private boolean isPlaceValid(){
        return  (grid.grid[x][y] == 'X' || grid.grid[x][y] == 'O');

    }

}
