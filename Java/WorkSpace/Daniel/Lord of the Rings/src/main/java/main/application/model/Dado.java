package main.application.model;

import java.util.Random;

public class Dado {
    public static Integer rolar(Integer max) {
        Random random = new Random();

        return random.nextInt(max + 1);
    }
}
