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
        
        //looping through each cell in the grid

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Cell cell = grid[row][col];

                //skip if the cell is a mine
                if (cell.isMine()) {
                    continue;
                }

                //count adj mines
                int count = 0;
                
                //check adjacent cell to current
                for (int r = row - 1; r <= row + 1; r++) {
                    for (int c = col - 1; c <= col + 1; c++) {


                        if (r < 0 || r >= size || c < 0 || c >= size) {
                            continue;
                        }


                        //skip our cell in middle
                        if (r == row && c == col) {
                            continue;
                        }
                        if (grid[r][c].isMine()) {
                            count++;

                        }

                    }
                }
                    

                cell.setAdjacentMines(count);
                }
                
                
            }
        }
    





    /* ------------------------ print the board on screen ----------------------- */

    public void PrintBoard() {

        System.out.print("   "); // Add space for row numbers
        for (int col = 0; col < size; col++) { // loop through the columns
            System.out.print(col + " "); // print column number
        }
        System.out.println(); // End the column header line

        //new line for the row numbers
        for (int row = 0; row < size; row++) { // loop through the rows
            System.out.print(row + "  "); // print row number

            for (int col = 0; col < size; col++) { // loop through the columns
                Cell cell = grid[row][col];
                if (!cell.isRevealed()) {
                    System.out.printf("- "); // hidden cells will display
                } else if (cell.isMine()) {
                    System.out.printf("* "); // revelead mines will show this
                } else {
                    int mineCount = cell.getAdjacentMines();
                    if (mineCount == 0) {
                        System.out.print("\u001B[34m" + "0" + "\u001B[0m ");
                    } else {
                        switch (mineCount) {
                            case 1:
                                System.out.print("\u001B[34m" + mineCount + "\u001B[0m "); // Blue
                                break;
                            case 2:
                                System.out.print("\u001B[32m" + mineCount + "\u001B[0m "); // Green
                                break;
                            case 3:
                                System.out.print("\u001B[31m" + mineCount + "\u001B[0m "); // Red
                                break;
                            default:
                                System.out.print("\u001B[35m" + mineCount + "\u001B[0m "); // Purple
                                break;
                        }
                    }
                }
            }
            System.out.println();

        }
    }


    /* --------------------- method to check if the user won -------------------- */
    /* --------------- // all non-mine cells have to be revelead //--------------- */

    public boolean winStatus() {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Cell cell = grid[row][col];
                if (!cell.isMine() && !cell.isRevealed()) {
                    return false; //not won yet
                }
            }
        }
        return true; //win win
    }




    
    /* ----------------------------- Getter methods ----------------------------- */
    
    //so that game class have access to size because our var is private in this class
    public int getSize() { 
        return size;
    }

    public Cell getCell(int x, int y) {
        return grid[y][x];
    }


    



}
