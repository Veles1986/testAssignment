package main.assignment_28_10_2024;

import java.util.*;

public class UserPlatform {
    private Set<User> users = new HashSet<>();

    private void register(String username, String password) {
        if (users.add(new User(username, password))) {
            System.out.println("success : new user added");
            return;
        }
        System.out.println("fail: user already exists");
    }

    private void login(String username, String password) {
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
        System.out.println("fail: no such user");
    }

    private void logout(String username) {
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
        System.out.println("fail: no such user");
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] commands = new String[] {"register", "login", "logout"};
        while (!string.equalsIgnoreCase("exit")) {
            String[] strings = string.split(" ");
            if (!List.of(commands).contains(strings[0]) || strings.length < 2 || strings.length > 3) {
                System.out.println("Invalid arguments, please, try again");
            } else {
                if (commands[0].equals(strings[0])) {
                    if (strings.length == 3) {
                        register(strings[1], strings[2]);
                    } else {
                        System.out.println("Invalid arguments, please, try again");
                    }
                } else if (commands[1].equals(strings[0])) {
                    if (strings.length == 3) {
                        login(strings[1], strings[2]);
                    } else {
                        System.out.println("Invalid arguments, please, try again");
                    }
                } else if (commands[2].equals(strings[0])) {
                    if (strings.length == 2) {
                        logout(strings[1]);
                    } else {
                        System.out.println("Invalid arguments, please, try again");
                    }
                } else {
                    System.out.println("Invalid arguments, please, try again");
                }
            }
            System.out.println("Enter \"exit\" to end the session");
            string = scanner.nextLine();
        }
        System.out.println("End of session. Thank you");
    }

    public static void main(String[] args) {
        UserPlatform userPlatform = new UserPlatform();
        userPlatform.run();
    }
}
