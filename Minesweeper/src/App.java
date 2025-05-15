import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        System.out.print("Enter grid size (eg: 10 for 10x10 grid): ");
        int size = s.nextInt();

        char[][] board = new char[size][size]; //https://www.scaler.com/topics/java/multidimensional-array-in-java/

        /* -------------- painting the board or initialising every cell ------------- */
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = '-';
            }
        }
       
        /* ------------------------ print whats in every cell ----------------------- */
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.err.println(); //moves to next line after each interation or row 
        }


        s.close();
    }
}
