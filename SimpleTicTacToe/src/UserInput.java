import java.util.Scanner;

public class UserInput {

    int x;
    int y;

    public void inputNumbers() {
        Grid grid = Grid.getInstance("X_X_O____");
        readNumbers();
        displayNumbers();
    }

    private void readNumbers() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            if (parseNumbers(parts)) {
                if (isValidCoordinates(x)) {
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
    private void displayNumbers() {
        System.out.println("Your number is: " + x);
        System.out.println("Second number is: " + y);
    }


}
