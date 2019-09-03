package pl.qa.selenium;

import java.time.Duration;
import org.apache.commons.lang3.RandomUtils;

public class Dog implements Animal {

  private static final int DEFAULT_LEGS = 4;
  private final int legs;

  public Dog(int legs) {
    this.legs = legs;
  }

  public Dog() {
    this(RandomUtils.nextInt(2, 5));
  }

  @Override
  public void greeting() {
    Animal.super.greeting();
    System.out.println(String.format("\tI have %d legs%s", legs,
        legs != DEFAULT_LEGS ? ", which is unusual." : "."));
  }
  
  @Override
  public String plural() {
    return "Dogs";
  }
  
  @Override
  public Duration sleepPreference() {
    return Duration.ofHours(10);
  }

}
