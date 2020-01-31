package org.gdpi.course.utils;

public class FromCheck {
    private static String username = "[0-9a-zA-Z]{6,12}";
    private static String password = "[0-9a-zA-Z\\.]{6,30}";
    private static String nickname = "\\S{1,30}";

    public static boolean username(String username) {
        return username.matches(FromCheck.username);
    }

    public static boolean password(String password) {
        return password.matches(FromCheck.password);
    }

    public static boolean nickname(String nickname) {
        return nickname.matches(FromCheck.nickname);
    }
}
