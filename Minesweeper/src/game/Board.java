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
    
    public void calculateAdjacents() {
        
    }


}
