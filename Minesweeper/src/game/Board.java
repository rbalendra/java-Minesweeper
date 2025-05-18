package game;

import java.util.Random;

public class Board {

    private final int size = 10; //size of square board
    private final int mineCount = 10; // mines to hide
    
    private Cell[][] grid; //2d array to store cells

    /* ------------------ lets initialise the board with mines ------------------ */

    public Board() { //contructor here to initialise objects of a class

        grid = new Cell[size][size]; //creates new grid to store cell objects

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = new Cell(); //creating new cell instance
            }
            // System.out.println("Row " + row + " initialised");
        }

        placeMines(); // randomly place mines

        calculateAdjacents();

    }
    
    /* ------------------------- placing mines in cells ------------------------- */
    private void placeMines() {
        Random rand = new Random(); //generate random obj
        int placed = 0; // initialise counter to track how many mines placed

        while (placed < mineCount) { //place mines until we meet the size
            int row = rand.nextInt(size); //generate random 0-9
            int col = rand.nextInt(size);

            Cell cell = grid[row][col]; //get the random row col position
            if (!cell.isMine()) {
                cell.setMine(true); //place it
                placed++; //increment our placed counter since we placed one
            }

        }
    }
    


    /* ----------------------- calculate the adjacentMines ---------------------- */
    public void calculateAdjacents() {
        
    }





    /* ------------------------ print the board on screen ----------------------- */

    public void PrintBoard() {
        
        System.out.print("   "); // Add space for row numbers
        for (int col = 0; col < size; col++) { // loop through the columns
            System.out.print(col + " "); // print column number
        }
        System.out.println(); // End the column header line

        //new line for the row numbers
        for (int row = 0; row < size; row++) {  // loop through the rows
            System.out.print(row + "  "); // print row number


            for (int col = 0; col < size; col++) { // loop through the columns
                Cell cell = grid[row][col];
                if (!cell.isRevealed()) {
                    System.out.printf("- "); // hidden cells will display
                } else if (cell.isMine()) {
                    System.out.printf("* "); // revelead mines will show this
                } else {
                    System.out.printf(cell.getAdjacentMines() + " "); //will be empty 
                }
            }
            System.out.println();
            
        }




    }




}
