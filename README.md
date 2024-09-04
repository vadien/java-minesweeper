# Minesweeper in Java

## Requirements / Purpose

- My first Java project: A recreation of the classic game in Java, entirely in the CLI.
- Reinforcing good OOP coding principles and building familiarity with the Java standard library
- Built entirely in Java 21!

---

## Instructions

- Successfully mark all mines to win the game!
- The number of mines is determined by the width of the board.

- You can either CHECK or MARK cells.
- To check a cell, enter the character 'C' followed by the cell you wish to check.
- To mark a cell that contains a mine, enter the character 'M' or 'B' before the cell.
- For example to CHECK the cell A1, enter 'Ca1'. To MARK it as a mine, enter 'Ba1'.
- All inputs are case insensitive.
- Enter 'h' at any time for other instructions.

---

## Build Steps

- Ensure you have Java JRE 21 installed
- Run App.java within VSCode or your preferred compiler

---

## Design Goals / Approach

- Goal: To enable smooth storage and handling of the game data
- Goal: To build a 'complete' experience with error handling and win/fail states
- Goal: To provide a logical control method for CLI-based input

- To facilitate goals 2 & 3 I implemented the win condition as the player successfully 'marking' all mines. In other versions of the game the player wins by revealing all non-mine cells, however the repeated inputs quickly became tiresome.

---

## Features

- Selectable grid size from 1 - 25 rows
- Included instructions
- Restarting from game over

---

## Known issues

None! 🥳

---

## Future Goals

- Currently the game uses marking mines as a win condition (to prevent the player having to manually clear each cell one by one). I will update this to also allow victory by revealing all non-mine squares.

---

## Challenges

- Deciding on a cell storage method was probably the largest decision of the project and carried the greatest repercussions. I thought using an ArrayList of single digits was a novel and clever approach, but I still ended up needing a second ArrayList to handle which cells are revealed to the player. If I were to reattempt this challenge I would try to use a more elegant data structure like a HashMap.

---

## Licensing Details

MIT License

Copyright (c) 2024 David Neill

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
