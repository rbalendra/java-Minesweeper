package game;
import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    private Board board;  //making this variable available to all methods in this class

    public Game() { //contructor
        board = new Board();
    }
    

    /* -------------------------- method to get inputs -------------------------- */
    public void gameStart() { 
        board.PrintBoard();
        int num1;
        int num2;
        System.out.println();
        System.out.println("Enter x & y value: ");
        num1 = scan.nextInt();
        num2 = scan.nextInt();
        System.out.println("You entered: " + num1 + " & " + num2);
    }


}
