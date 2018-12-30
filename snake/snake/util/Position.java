package snake.util;

import snake.exception.InvalidIndexException;

public class Position {

  public static final int SIZE_OF_BOARD = 10;
  private final int row;
  private final int column;

  public Position(int row, int column) {
    if(row >= 0 && row < SIZE_OF_BOARD && column >= 0 && column < SIZE_OF_BOARD) {
      this.row = row;
      this.column = column;
    } else {
      throw new InvalidIndexException();
    }
  }

  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.column;
  }

  public boolean isSame(Position position) {
    if(position != null && this.row == position.getRow() && this.column == position.getColumn()) {
      return true;
    } else {
      return false;
    }
  }

  public boolean equals(Object obj) {
    boolean result = false;
    Position pos = (Position) obj;
    if(pos.getRow() == row && pos.getColumn() == column) {
      result = true;
    }
    return result;
  }

  public int hashCode() {
    return row + column;
  }

}
