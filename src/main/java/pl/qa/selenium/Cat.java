package pl.qa.selenium;

import java.time.Duration;
import org.apache.commons.lang3.RandomUtils;

public class Cat implements Animal {

  private Duration sleepPreference;
  
  public Cat() {
    sleepPreference = Duration.ofHours(RandomUtils.nextInt(16, 20));
  }
  
  @Override
  public String plural() {
    return "Cats";
  }
  
  @Override
  public Duration sleepPreference() {
    return sleepPreference;
  }
  
}
