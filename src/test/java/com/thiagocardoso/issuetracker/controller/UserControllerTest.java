package com.thiagocardoso.issuetracker.controller;

import com.thiagocardoso.issuetracker.document.User;
import com.thiagocardoso.issuetracker.repository.UserRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserController controller;

    @Before
    public void setup() {
        when(repository.findAll()).thenReturn(Flux.just(User.from("test@test.com", "123", "test")));
    }

    @Test
    public void checkExistence() {
        assertThat(controller, Matchers.is(notNullValue()));
    }

    @Test
    public void methodGet_emptyReturn() {
        when(repository.findAll()).thenReturn(Flux.just());

        Flux<User> users = controller.get();

        assertThat(users.collectList().block(), Matchers.is(empty()));
    }

    @Test
    public void methodGet_returnOneUser() {
        Flux<User> users = controller.get();

        List<User> userList = users.collectList().block();
        assertThat(userList, Matchers.is(not((empty()))));
        assertThat(userList.size(), Matchers.is(Matchers.equalTo(1)));
    }
}
