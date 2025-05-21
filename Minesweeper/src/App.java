import game.Game;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\u001B[31m" + "WELCOME TO MINESWEEPER!" + "\u001B[0m ");
    
        Game game = new Game(); 
        game.gameStart(); 

    }
}
