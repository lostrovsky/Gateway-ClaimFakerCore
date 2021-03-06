package com.ust.claimfaker.core;

import com.ust.claimfaker.core.Faker;

public class Zelda {
    private final Faker faker;

    protected Zelda(final Faker faker) {
        this.faker = faker;
    }

    public String game() {
        return faker.resolve("zelda.games");
    }

    public String character() {
        return faker.resolve("zelda.characters");
    }
}
