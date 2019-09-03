package pl.qa.selenium.tests;

import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith({JTestWatcher.class})
class FirstJUnitTest {

  private static final Logger logger = LoggerFactory.getLogger(FirstJUnitTest.class);

  @BeforeAll
  static void beforeAll() {
    // Quick and dirty logger configuration
    BasicConfigurator.configure();
  }

  @BeforeEach
  void beforeEach() {
    logger.debug("Before each test");
  }

  @AfterEach
  void afterEach() {
    logger.debug("After each test");
  }
  
  @DisplayName("Simple Limit Test")
  @Test
  @Disabled("This test was not well liked")
  void simpleProof() {
    // lim_{x->+0} 1/x = +infinity
    double value = 1d / +0;
    Assertions.assertTrue(value == Double.POSITIVE_INFINITY);
  }

  @DisplayName("Csv Test")
  @CsvFileSource(resources = {"/test.csv"}, numLinesToSkip = 1)
  @ParameterizedTest
  void csvTest(String name, String value, String optional) {
    Assertions.assertNotNull(name, "Name must be present");
    Assertions.assertNotNull(value, "Value must be present");
  }

  @DisplayName("Basic test")
  @Test
  void basicTest() {
    Assertions.assertAll("Math is still real", () -> Assertions.assertTrue(1 + 1 == 2),
        () -> Assertions.assertTrue(1 + 2 == 3));
  }

}
