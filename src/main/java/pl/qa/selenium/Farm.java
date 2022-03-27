package pl.qa.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.util.Assert;

public class Farm {

  private static final int NUM_ANIMALS = 10;

  private List<Class<? extends Animal>> availableAnimals;
  private List<Animal> farmAnimals;

  public Farm() {
    availableAnimals = new ArrayList<>();
    farmAnimals = new ArrayList<>();

    availableAnimals.add(Dog.class);
    availableAnimals.add(Cat.class);
    availableAnimals.add(Horse.class);
  }

  void populateFarm(int numAnimals) {
    Assert.isTrue(!availableAnimals.isEmpty(), "Must have animals to pick from!");

    for (int animalIndex = 0; animalIndex < numAnimals; animalIndex++) {
      try {
        farmAnimals.add(availableAnimals.get(RandomUtils.nextInt(0, availableAnimals.size()))
            .newInstance());
      } catch (InstantiationException | IllegalAccessException e) {
        System.err.println("Failed to breed animal...");
        e.printStackTrace();
      }
    }
  }

  void greet() {
    
    System.out.println(
        String.format("We have %d animals, let's introduce ourselves:", farmAnimals.size()));
    farmAnimals.forEach(Animal::greeting);
    
    farmAnimals.stream()
        .collect(Collectors.groupingBy(Animal::getClass,
            Collectors.averagingLong(a -> a.sleepPreference()
                .toHours())))
        .entrySet()
        .forEach(a -> System.out
            .println(String.format("Our %ss like to sleep for about %.2f hours a day", a.getKey()
                .getSimpleName(), a.getValue())));
  }


  public static void main(String[] args) {
    Farm farm = new Farm();
    farm.populateFarm(NUM_ANIMALS);
    farm.greet();
  }

}
