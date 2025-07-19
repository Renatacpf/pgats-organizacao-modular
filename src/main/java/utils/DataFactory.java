package utils;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class DataFactory {

    public static String generateRandomName() {
        return "User_" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static String generateRandomEmail() {
        return "test_" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
    }

    public static String generateRandomPassword() {
        return "Password" + ThreadLocalRandom.current().nextInt(1000, 9999);
    }
}