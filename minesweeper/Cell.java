package minesweeper;

public class Cell {
  private boolean mine;
  private boolean revealed;

  public boolean isMine() {
    return mine;
  }
  public boolean isRevealed() {
    return revealed;
  }
  public void setMine(boolean mine) {
    this.mine = mine;
  }
  public void setRevealed(boolean revealed) {
    this.revealed = revealed;
  }
}
