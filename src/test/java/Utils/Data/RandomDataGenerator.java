package Utils.Data;

import com.github.javafaker.Faker;

public class RandomDataGenerator {
  private static Faker faker;

  private RandomDataGenerator() {
    faker = new Faker();
  }

  public static String generateRandomEmail() {
    return faker.internet().emailAddress();
  }

  public static String generateRandomPassword(int minLength, int maxLength) {
    return faker.internet().password(minLength, maxLength);
  }
}