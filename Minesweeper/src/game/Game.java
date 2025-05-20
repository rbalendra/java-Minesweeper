package game;
import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    private Board board; //making this variable available to all methods in this class
    private boolean gameOver;

    public Game() { //contructor
        board = new Board();
        gameOver = false;
    }

    /* -------------------------- method to get inputs -------------------------- */
    public void gameStart() {
        while (!gameOver) {
            board.PrintBoard();
            int x;
            int y;
            System.out.println();
            System.out.println("Enter x & y value: ");
            x = scan.nextInt();
            y = scan.nextInt();

            //validation
            if (x >= 0 && x < board.getSize() && y >= 0 && y < board.getSize()) {
                revealCell(x, y);
            } else {
                System.out.println("invalid coordinates: try again");
            }
        }
        scan.close();
    }

/* --------------------------- reveal cell method --------------------------- */

private void revealCell(int x, int y) {
    Cell cell = board.getCell(x, y); //asking the board to give me cell obj at x,y

    if (cell.isRevealed()) {
        System.out.println("This cell is already revealed");
        return;
    }

    cell.setRevealed(true); // reveal cell

    if (cell.isMine()) {
        board.PrintBoard();
        System.out.println("BOOM! BOOM! game over");
        gameOver = true;
    }

    if (board.winStatus()) {
        board.PrintBoard();
        System.out.println("congragulations you won!");
        gameOver = true;
    }

}



}