# Project: Minesweeper (Simplified CLI edition)

<img src="https://github.com/user-attachments/assets/9b1fb0fe-5129-41d2-9ab6-6ec02e445a03" alt="javaMInsweeper" width="300"/>

## Game Structure
- Classic minesweeper implementation in Java with 10x10 grid and 10 mines
- Organised into 4 main classes: Cell, Board, Game and App

## Key Components
#### Cell Class 
- Represents individual cells on board
- Tracks if cell contains a mine or is revealed
- Contains the getters/setters for all properties

#### Board Class
- Creates and prints the 10 x 10 grid of Cell objects
- Randomly places the mines
- Calculates the number of adjacent mines
- renders the board with colour coded numbers
- checks win condition (for all non-mine cells)

#### Game Class
- Manages game flow and user interaction
- Handles player inputs for cell coordinates
- Reveals cells and checks for win/loss conditions
- Displays appropriate messages to the player

#### App Class
- Entry point for application
- Instantiate the game
