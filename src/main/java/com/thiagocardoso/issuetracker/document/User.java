package com.thiagocardoso.issuetracker.document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Document(collection = "users")
public class User {
    String email;
    String password;
    String name;

    public static User of() {
        return new User("", "", "");
    }

    public static User from(String email, String password, String name) {
        return new User(email, password, name);
    }
}
