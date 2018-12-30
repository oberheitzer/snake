package snake;

import snake.util.Direction;
import snake.exception.CollisionException;

public interface Snake extends Tile {

  public void move(Direction dir) throws CollisionException;

  public void move(Direction dir, int times) throws CollisionException;

}
