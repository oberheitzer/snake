package snake.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import snake.Apple;
import snake.Game;
import java.lang.IllegalArgumentException;

public class ToApplesTest {

  @Test (expected = NullPointerException.class)
  public void shouldMakeEmptyApplesWhenNoLineRead() {
    ArrayList<String> lines = null;
    ArrayList<Apple> listOfApples = Game.toApples(lines);
    assertEquals("The list is not empty", listOfApples.size(), (new ArrayList<Apple>()).size());
  }

  @Test (expected = IllegalArgumentException.class)
  public void shouldMakeEmptyApplesWhenEmptyLineRead() {
    ArrayList<String> lines = new ArrayList<String>();
    ArrayList<Apple> listOfApples = Game.toApples(lines);
    assertEquals("The list is not empty", listOfApples.size(), (new ArrayList<Apple>()).size());
  }

  @Test
  public void shouldMakeEmptyListWhenTheLineStartsWithWhitespace() {
    ArrayList<String> lines = new ArrayList<String>();
    lines.add(" 4 2");
    ArrayList<Apple> listOfApples = Game.toApples(lines);
    assertEquals("The list is not empty", listOfApples.size(), (new ArrayList<Apple>()).size());
  }

  @Test
  public void shouldMakeEmptyListWhenTheLineContainsTooMuchSpace() {
    ArrayList<String> lines = new ArrayList<String>();
    lines.add("4  2");
    ArrayList<Apple> listOfApples = Game.toApples(lines);
    assertEquals("The list is not empty", listOfApples.size(), (new ArrayList<Apple>()).size());
  }

  @Test
  public void shouldMakeEmptyListWhenTheIndexOfRowIsNotANumber() {
    ArrayList<String> lines = new ArrayList<String>();
    lines.add("four  2");
    ArrayList<Apple> listOfApples = Game.toApples(lines);
    assertEquals("The list is not empty", listOfApples.size(), (new ArrayList<Apple>()).size());
  }

  @Test
  public void shouldMakeAppleListWhenThereIsOneCorrectLine() {
    ArrayList<String> lines = new ArrayList<String>();
    lines.add("4 2");
    ArrayList<Apple> listOfApples = Game.toApples(lines);
    assertEquals("The list is not empty", listOfApples.size(), 1);
  }

  @Test
  public void shouldMakeEmptyListWhenTheEelementsIsNotCorrect() {
    ArrayList<String> lines = new ArrayList<String>();
    lines.add("-4  11");
    ArrayList<Apple> listOfApples = Game.toApples(lines);
    assertEquals("The list is not empty", listOfApples.size(), (new ArrayList<Apple>()).size());
  }

  @Test
  public void shouldMakeAppleListWhenThereAreTheNumbersOfBorderlineCases() {
    ArrayList<String> lines = new ArrayList<String>();
    lines.add("0 9");
    ArrayList<Apple> listOfApples = Game.toApples(lines);
    assertEquals("The list is not empty", listOfApples.size(), 1);
  }

  @Test
  public void shouldMakeAppleListWhenThereAreTwoCorrectLines() {
    ArrayList<String> lines = new ArrayList<String>();
    lines.add("4 2");
    lines.add("8 4");
    ArrayList<Apple> listOfApples = Game.toApples(lines);
    assertEquals("The list is not empty", listOfApples.size(), 2);
  }

  @Test
  public void shouldMakeAppleListWhenThereAreALotOfCorrectLines() {
    ArrayList<String> lines = new ArrayList<String>();
    lines.add("4 2");
    lines.add("8 4");
    lines.add("2 9");
    lines.add("0 6");
    lines.add("5 2");
    ArrayList<Apple> listOfApples = Game.toApples(lines);
    assertEquals("The list is not empty", listOfApples.size(), 5);
  }

}
