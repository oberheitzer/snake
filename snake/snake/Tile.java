package snake;

import snake.util.Position;
import snake.util.PositionMap;

public interface Tile {

  public Position getPosition();

  public void print(PositionMap<Character> map);

}
