package snake.parts;

import snake.parts.SnakeTail;
import snake.util.Direction;
import snake.util.Position;
import snake.exception.CollisionException;
import snake.exception.InvalidIndexException;
import snake.util.PositionMap;
import snake.Game;
import snake.Snake;


public class SnakeHead extends SnakeTail implements Snake {

  private final Game game;
  private SnakeTail tail;

  public SnakeHead(Position position, Position positionOfTail, Game game) {
    super(position);
    this.game = game;
    this.tail = new SnakeTail(positionOfTail);
  }

  @Override
  public void move(Direction dir, int times) throws CollisionException {
    int i = 0;
    while(i < times && !(times <= 0)) {
      move(dir);
      ++i;
    }
  }

  @Override
  public void move(Direction dir) throws CollisionException {

    int row = getPosition().getRow();
    int column = getPosition().getColumn();

    switch(dir) {
      case UP : move(row - 1, column);
        break;
      case DOWN : move(row + 1, column);
        break;
      case RIGHT : move(row, column + 1);
        break;
      case LEFT : move(row, column - 1);
        break;
    }
  }

  private void move(int row, int column) throws CollisionException {
    try{
      Position pos = new Position(row, column);
      if(tail.isAt(pos)) {
        throw new CollisionException();
      } else {
        if(this.game.getApple() != null && this.game.getApple().getPosition().equals(pos)) {
          this.tail = new SnakeTailPart(this.getPosition(), this.tail);
          this.game.ateApple();
          this.moveTo(pos);
        } else {
          tail.moveTo(this.getPosition());
          this.moveTo(pos);
        }
      }
    } catch(InvalidIndexException e) {
      throw new CollisionException();
    } catch(NullPointerException ne) {}
  }

  public void print(PositionMap<Character> map) {
    map.put(this.getPosition(), '@');
    this.tail.print(map);
  }

}
