# java-minesweeper

## Instructions:

- Successfully mark all mines to win the game!
- The number of mines is determined by the width of the board.

- You can either CHECK or MARK cells.
- To check a cell, enter the character 'C' followed by the cell you wish to check.
- To mark a cell that contains a mine, enter the character 'M' or 'B' before the cell.
- For example to CHECK the cell A1, enter 'Ca1'. To MARK it as a mine, enter 'Ba1'.
- All inputs are case insensitive.
- Enter 'h' at any time for other instructions.

## Project MVP:

- Recreate a simplified version of the game Minesweeper to be played in the java console
- The game should be able to randomly generate 10 mines in a 10x10 grid
- The user will be able to enter a command that represents a coordinate to check a location for a mine
- The application will display a number from 0-8 depending on how many mines surround that location
- If the user selects a mine, the game will respond "boom!" and the game will be lost
- If every non-mine square has been revealed, the game is won
- Render the grid to the console after every user command

## TODO:

- Currently the game uses marking mines as a win condition (to prevent the player having to manually clear each cell one by one). I will update this to also allow victory by revealing all non-mine squares.
