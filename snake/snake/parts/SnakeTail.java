package snake.parts;

import snake.util.Position;
import snake.util.PositionMap;
import snake.Tile;

public class SnakeTail implements Tile {

  private Position position;

  public SnakeTail(Position position) {
    this.position = position;
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  protected void moveTo(Position position) {
    this.position = position;
  }

  protected boolean isAt(Position position) {
    return this.position.equals(position);
  }

  public void print(PositionMap<Character> map) {
    map.put(this.position, '~');
  }

}
