public class Game {
    Grid grid;
    UserInput userInput;
    GameAnalyze gameAnalyze;

    public Game(){
        grid = Grid.getInstance();
        userInput = new UserInput();
        gameAnalyze = new GameAnalyze();
        gameLoop();
    }

    private void gameLoop(){

        while (true) {
            userInput.userLoop('O');
            if (gameAnalyze.gameAnalyze(grid.grid)){
                break;
            }
            userInput.userLoop('X');
            if (gameAnalyze.gameAnalyze(grid.grid)){
                break;
            }
        }
    }
}
