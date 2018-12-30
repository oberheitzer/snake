package snake.util;

import java.util.Map;
import java.util.HashMap;
import snake.util.Position;

public class PositionMap<T> {

  private final Map<Position, T> map;
  private final T defaultValue;

  public PositionMap(T defaultValue) {
    this.defaultValue = defaultValue;
    this.map = new HashMap<>();
  }

  public void put(Position pos, T element) {
    map.put(pos, element);
  }

  public T get(Position pos) {
    T isIn = map.get(pos);
    if(isIn != null) {
      return isIn;
    } else {
      return defaultValue;
    }
  }

}
