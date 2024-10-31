package main.assignment_28_10_2024;

import java.util.*;

public class UserPlatform {


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

    private Set<User> users = new HashSet<>();

    private void register(String username, String password) {
        if (users.add(new User(username, password))) {
            System.out.println("success: new user added");
            return;
        }
        System.out.println("fail: user already exists");
    }

    private void login(String username, String password) {
        if (!users.isEmpty()) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    if (user.getPassword().equals(password)) {
                        if (user.isLoggedIn()) {
                            System.out.println("fail: already logged in");
                            return;
                        }
                        user.changeLoggedInStatus();
                        System.out.println("success: user logged in");
                        return;
                    } else {
                        System.out.println("fail: incorrect password");
                        return;
                    }
                }
            }
        }
        System.out.println("fail: no such user");
    }

    private void logout(String username) {
        if (!users.isEmpty()) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    if (!user.isLoggedIn()) {
                        System.out.println("fail: already logged out");
                        return;
                    }
                    user.changeLoggedInStatus();
                    System.out.println("success: user logged out");
                    return;
                }
            }
        }
        System.out.println("fail: no such user");
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String[] commands = new String[] {"register", "login", "logout"};
        for (int i = 0; i < number; i++) {
            String string = scanner.nextLine();
            String[] strings = string.split(" ");
            if (commands[0].equals(strings[0])) {
                register(strings[1], strings[2]);
            } else if (commands[1].equals(strings[0])) {
                login(strings[1], strings[2]);
            } else {
                logout(strings[1]);
            }
        }
    }

    public static void main(String[] args) {
        UserPlatform userPlatform = new UserPlatform();
        userPlatform.run();
    }
}
