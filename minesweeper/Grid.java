package minesweeper;

import java.util.Random;

public class Grid {
  private int size = 10;
  private char[][] displayGrid; // 2D array to represent starting grid
  private int[][] mineGrid;

  public Grid() {
    displayGrid = new char[size][size];
    System.out.println("Display grid" + displayGrid[0][0]);
    mineGrid = new int[size][size];
    initializeGrid();
    placeMines(10);
  }

  public boolean checkCells() {
    for (int y = 0; y < displayGrid.length; y++) { // rows
      for (int x = 0; x < displayGrid[y].length; x++) { // columns
        if(displayGrid[y][x] == ' ') {
          return false;
        }
      }
    }
    return true;
  }

  private void placeMines(int minesTotal) {
    Random random = new Random(); // initialize Random object to generate random numbers
    int minesPlaced = 0; // track amount of mines placed
    while (minesPlaced < minesTotal) {
      int x = random.nextInt(size); // generate random x & y coordinates
      int y = random.nextInt(size);
      if (mineGrid[y][x] != -1) {
        mineGrid[y][x] = -1; // -1 represent a cell with a mine
        minesPlaced++; // increment total if mine is placed
      }
    }
  }

  public boolean revealCell(int x, int y) {
    if (mineGrid[y][x] == -1) {
      displayGrid[y][x] = '*'; // show a mine
      return false; // game over
    } else {
      int mineCount = countNearbyMines(x, y);
      displayGrid[y][x] = (char) ('0' + mineCount);
    };
    return true;
  }

  private int countNearbyMines(int x, int y) {
    // for chosen cell, check each surrounding cell (8)
    // surrounding cell coord -->
    // x-1 y-1
    // x-1 y
    // x-1 y+1
    // x y-1
    // x y+1
    // x+1 y-1
    // x+1 y
    // x+1 y+1

    int mineCount = 0;
    // arrays that represent relative postions of surrounding cells
    int[] dx = {-1, -1, -1, 0, 0, +1, +1, +1}; // horizontal offsets
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1}; // vertical offsets

    for (int i = 0; i < 8; i++) { // iterates through all possible surrounding cells
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0
        && nx < size
        && ny >= 0
        && ny < size
        && mineGrid[ny][nx] == -1
        ) {
        mineCount++;
      }
    }
    return mineCount;
  }

  // initialize the grid with values
  public void initializeGrid() {
    for (int y = 0; y < displayGrid.length; y++) { // rows
      for (int x = 0; x < displayGrid[y].length; x++) { // columns
        displayGrid[y][x] = ' ';
        mineGrid[y][x] = 0;
      }
    }
  }

  public void printGrid() {
    System.out.print("   ");
    for (int x = 1; x <= size; x++) {
      System.out.print("  " + x + " ");
    }
    System.out.println();
    printHorizontalLines(size);

    for (int y = 0; y < size; y++) {
      printVerticalLines(y);
      printHorizontalLines(size);
    }
  }

  public void printHorizontalLines(int size) {
    System.out.print("   ");

    StringBuilder horizontalLine = new StringBuilder();
    for (int y = 0; y < size; y++) {
      horizontalLine.append("+---");
    }
    horizontalLine.append("+");
    System.out.println(horizontalLine.toString());
  }

  public void printVerticalLines(int rowIndex) {
    System.out.print(String.format("%2d ", rowIndex + 1));
    StringBuilder verticalLine = new StringBuilder();

    for (int y = 0; y < displayGrid[rowIndex].length; y++) {
      verticalLine.append(String.format("| %c ", displayGrid[rowIndex][y]));
    }
    verticalLine.append("|");
    System.out.println(verticalLine.toString());
  }
};
