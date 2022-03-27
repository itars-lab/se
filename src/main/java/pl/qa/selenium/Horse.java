package pl.qa.selenium;

import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import org.apache.commons.lang3.RandomUtils;

public class Horse implements Animal {

  private static final Deque<String> FAMOUS_HORSES;

  static {
    List<String> horses = new ArrayList<>();
    horses.add("Mr. Ed");
    horses.add("Black Beauty");
    horses.add("Man O' War");
    horses.add("Secretariat");
    Collections.shuffle(horses);
    FAMOUS_HORSES = new ArrayDeque<>(horses);
  }

  private Duration sleepPreference;
  private String name;

  public Horse(String name) {
    this.name = name;
    if (name == null) {
      this.name = "A Horse With No Name";
    }
    sleepPreference = Duration.ofMinutes(RandomUtils.nextInt(480, 600));
  }

  public Horse() {
    this(FAMOUS_HORSES.poll());
  }

  @Override
  public void greeting() {
    System.out.println(String.format("Good Day, I'm the talking horse %s!", name));
  }

  @Override
  public String plural() {
    return "Horses";
  }

  @Override
  public Duration sleepPreference() {
    return sleepPreference;
  }

}
