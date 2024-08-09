package minesweeper;

import java.util.Scanner;

public class Game {
  public static void main(String[] args) {

    System.out.println("Welcome to Minesweeper!");
    Scanner scanner = new Scanner(System.in);

    Grid grid = new Grid();
    grid.printGrid();
  }
}
