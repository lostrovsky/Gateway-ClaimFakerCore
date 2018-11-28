package com.ust.claimfaker.core;

import com.ust.claimfaker.core.Faker;

public class Pokemon {

    private final Faker faker;

    protected Pokemon(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return faker.resolve("pokemon.names");
    }

    public String location() {
        return faker.resolve("pokemon.locations");
    }
}
