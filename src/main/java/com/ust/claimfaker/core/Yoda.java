package com.ust.claimfaker.core;

import com.ust.claimfaker.core.Faker;

public class Yoda {
    private final Faker faker;

    protected Yoda(final Faker faker) {
        this.faker = faker;
    }

    public String quote() {
        return faker.resolve("yoda.quotes");
    }
}
