package redis.integration.backend.utils;

import java.util.Random;


public class TokenUtil {
    static public String generate() {
        Random random = new Random();
        return String.valueOf(random.nextInt(9999) + 1000);
    }
}