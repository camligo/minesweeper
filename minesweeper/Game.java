package minesweeper;

import java.util.Scanner;

public class Game {
  private Grid grid;

  public Game() {
    this.grid = new Grid();
  }

  public void startPlaying() {
    System.out.println("---------------------------------------------");
    System.out.println("            Welcome to Minesweeper!");
    System.out.println("---------------------------------------------");
    System.out.println("If you hit a mine, the game is over.");
    System.out.println();

    Scanner scanner = new Scanner(System.in);

    while(true) {
      grid.printGrid();
      System.out.println();

      System.out.print("Enter row number (1-10): ");
      int row = scanner.nextInt() - 1;
      System.out.print("Enter column number (1-10): ");
      int col = scanner.nextInt() - 1;

      boolean safeCell = grid.revealCell(col, row);
      if (!safeCell) {
        System.out.println("Boom! Game over.");
        System.out.println();
        grid.printGrid();
        break;
      }
      if (grid.checkCells()) {
        System.out.println("You won!");
        break;
      }
      System.out.println("No mine, continue");
      System.out.println();
    }
  }
}
