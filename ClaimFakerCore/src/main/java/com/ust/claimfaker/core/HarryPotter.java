package com.ust.claimfaker.core;

import com.ust.claimfaker.core.Faker;

public class HarryPotter {
    private final Faker faker;

    protected HarryPotter(final Faker faker) {
        this.faker = faker;
    }

    public String character() {
        return faker.resolve("harry_potter.characters");
    }

    public String location() {
        return faker.resolve("harry_potter.locations");
    }

    public String quote() {
        return faker.resolve("harry_potter.quotes");
    }

    public String book() {
        return faker.resolve("harry_potter.books");
    }
}
