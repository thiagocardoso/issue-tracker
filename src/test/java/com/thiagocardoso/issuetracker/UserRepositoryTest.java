package com.thiagocardoso.issuetracker;

import com.thiagocardoso.issuetracker.document.User;
import com.thiagocardoso.issuetracker.repository.UserRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import static org.hamcrest.Matchers.notNullValue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void createUser() {
        User of = User.of("", "");
        StepVerifier.create(repository.save(of)).expectNext(of).verifyComplete();
    }

    @Test
    public void createRetrieveAndCheckInfo() {
        User user = User.from("test@test.com", "123", "test");
        repository.save(user).then().block();

        User userFound = repository.findByEmail("test@test.com").block();

        MatcherAssert.assertThat(userFound, notNullValue());
        MatcherAssert.assertThat(userFound.getEmail(), Matchers.is(Matchers.equalTo("test@test.com")));
        MatcherAssert.assertThat(userFound.getName(), Matchers.is(Matchers.equalTo("test")));
        MatcherAssert.assertThat(userFound.getPassword(), Matchers.is(Matchers.equalTo("123")));
    }

    @Test
    public void createAndDelete() {
        User user = User.from("test@test.com", "123", "test");
        repository.save(user).then().block();

        User found = repository.findByEmail("test@test.com").block();

        StepVerifier.create(repository.deleteById(found.getId())).expectNextCount(0);
    }
}
