package minesweeper;

public class Grid {
  int size = 10;
  int[][] gridArray; // 2D array to represent grid

  public Grid() {
    gridArray = new int[size][size];
    startGrid();
  }
  // initialize the grid with values
  public void startGrid() {
    for (int y = 0; y < gridArray.length; y++) { // rows
      for (int x = 0; x < gridArray[y].length; x++) { // columns
        gridArray[y][x] = '*';
      }
    }
  }

  public void printGrid() {
    int size = gridArray.length;

    printTopBorder(size);

    for (int x = 0; x < size; x++) {
      printGridRow(x);
      printTopBorder(size);
    }
  }

  public void printTopBorder(int size) {
    StringBuilder border = new StringBuilder();
    for (int y = 0; y < size; y++) {
      border.append("+---");
    }
    border.append("+");
    System.out.println(border.toString());
  }

  public void printGridRow(int rowIndex) {
    StringBuilder row = new StringBuilder();
    for (int y = 0; y < gridArray[rowIndex].length; y++) {
      row.append(String.format("| %c ", gridArray[rowIndex][y]));
    }
    row.append("|");
    System.out.println(row.toString());
  }
};
