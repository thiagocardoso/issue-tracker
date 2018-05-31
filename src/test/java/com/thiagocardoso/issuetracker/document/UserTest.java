package com.thiagocardoso.issuetracker.document;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UserTest {

    @Test
    public void create() {
        assertThat(User.of(), Matchers.is(notNullValue()));
    }

    @Test
    public void shouldHaveTheseProperties() {
        final User user = User.from("email", "password", "name");

        assertThat(user.getEmail(), Matchers.is(equalTo("email")));
        assertThat(user.getPassword(), Matchers.is(equalTo("password")));
        assertThat(user.getName(), Matchers.is(equalTo("name")));
    }
}
