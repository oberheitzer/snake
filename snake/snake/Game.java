package snake;

import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;
import snake.exception.CollisionException;
import snake.exception.InvalidIndexException;
import snake.util.Position;
import snake.util.PositionMap;
import snake.util.Direction;
import snake.Apple;
import snake.parts.SnakeHead;

public class Game {

  private final List<Apple> apples;
  private final Snake snake;

  public Game(List<String> apples) {
    this.apples = toApples(apples);
    this.snake = new SnakeHead(new Position(0,1), new Position(0,0), this);
  }

  public static ArrayList<Apple> toApples(List<String> lines) throws IllegalArgumentException {
    ArrayList<Apple> listOfApples = new ArrayList<>();
    if(lines.isEmpty()) {
      throw new IllegalArgumentException();
    } else {
      String[] data;
      for(String line : lines) {
        if(line.matches("([0-9]\\s[0-9])")) {
          data = line.trim().split(" ");
          listOfApples.add(new Apple(new Position(Integer.parseInt(data[0]), Integer.parseInt(data[1]))));
        }
      }
    }
    return listOfApples;
  }

  public Apple getApple() {
    if(!(apples.isEmpty())) {
      return apples.get(0);
    } else {
      return null;
    }
  }

  public void ateApple() {
    apples.remove(0);
  }

  public String play(List<String> moves) {
    StringBuilder sb = new StringBuilder();
    try{
      if(!(moves.isEmpty())) {
        String[] data;
        Direction direction;
        int repeatingNumber;
        for(String line : moves) {
          if(line.matches("([A-Z]{2,5})") || line.matches("([A-Z]{2,5}\\s-?[0-9])")) {
            data = line.trim().split(" ");
            if(data.length == 1) {
              direction = Direction.valueOf(data[0]);
              snake.move(direction);
              printState(sb);
            }
            if(data.length == 2) {
              direction = Direction.valueOf(data[0]);
              repeatingNumber = Integer.parseInt(data[1]);
              snake.move(direction, repeatingNumber);
              printState(sb);
            }
          }
        }
      }

    } catch(CollisionException ce) {
      sb.append("GAME OVER");
    }
    return sb.toString();
  }

  private void printState(StringBuilder sb) {
    PositionMap<Character> posMap = new PositionMap<>(' ');
    snake.print(posMap);
    if(!(apples.isEmpty())) {
      getApple().print(posMap);
    }
    for(int i = 0; i < Position.SIZE_OF_BOARD; ++i) {
      for(int j = 0; j < Position.SIZE_OF_BOARD; ++j) {
          Position pos = new Position(i, j);
          sb.append(posMap.get(pos));
      }
      sb.append(System.lineSeparator());
    }
    sb.append("==========");
    sb.append(System.lineSeparator());
  }

}
