package snake.parts;

import java.lang.IllegalArgumentException;
import snake.util.Position;
import snake.util.PositionMap;

public class SnakeTailPart extends SnakeTail {

  private final SnakeTail next;

  public SnakeTailPart(Position position, SnakeTail next) {
    super(position);
    if(next != null) {
      this.next = next;
    } else {
      throw new IllegalArgumentException();
    }
  }

  protected void moveTo(Position position) {
    this.next.moveTo(this.getPosition());
    super.moveTo(position);
  }

  protected boolean isAt(Position position) {
    if(this.getPosition().equals(position)) {
      return true;
    } else {
      return this.next.isAt(position);
    }
  }

  public void print(PositionMap<Character> map) {
    map.put(this.getPosition(), '#');
    this.next.print(map);
  }
}
