package snake;

import snake.util.Position;
import snake.util.PositionMap;

public class Apple implements Tile {

  private final Position position;

  public Apple(Position position){
    this.position = position;
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  public void print(PositionMap<Character> map) {
    map.put(this.position, 'o');
  }

}
