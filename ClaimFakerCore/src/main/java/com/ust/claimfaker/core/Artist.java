package com.ust.claimfaker.core;

import com.ust.claimfaker.core.Faker;

public class Artist {

    private final Faker faker;

    protected Artist(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return faker.fakeValuesService().fetchString("artist.names");
    }
}
