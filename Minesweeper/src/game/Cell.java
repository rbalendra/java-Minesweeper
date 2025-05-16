package game;

public class Cell {
    
    private boolean isMine; //is there a mine?
    private boolean isRevealed; //is it revealed in this cell?
    private int adjacentMines; //how many mines are there nearby

    public Cell() {

        this.isMine = false;
        this.isRevealed = false;
        this.adjacentMines = 0;

    }



/* --------------------------- Getters and setters -------------------------- */

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean isRevealed) {
        this.isRevealed = true;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int count) {
        this.adjacentMines = count; //count the mmines
    }
}
