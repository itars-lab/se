package pl.qa.selenium;

import java.time.Duration;

public interface Animal {

  default void greeting() {
    System.out.println(String.format("Good day, I am a talking %s", getClass().getSimpleName()));
  }

  String plural();

  Duration sleepPreference();

}
