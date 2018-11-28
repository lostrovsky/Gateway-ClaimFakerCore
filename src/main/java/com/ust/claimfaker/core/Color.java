package com.ust.claimfaker.core;

import com.ust.claimfaker.core.Faker;

public class Color {
    private final Faker faker;

    protected Color(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return faker.fakeValuesService().resolve("color.name", this, faker);
    }
}
