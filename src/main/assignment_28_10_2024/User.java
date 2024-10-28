package main.assignment_28_10_2024;

import java.util.Objects;

public class User {
    private String username;
    private String password;
    private boolean loggedIn;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void changeLoggedInStatus() {
        loggedIn = !loggedIn;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        User user = (User) object;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
