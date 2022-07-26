import java.util.Objects;

public class Primer {
    private Primer() {
    }

    public static boolean primer(String login,
                                 String password,
                                 String confirmPassword) {
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (loginExp | passwordExp e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void check(String login,
                              String password,
                              String confirmPassword) throws loginExp, passwordExp {
        if (login == null || login.isEmpty() || login.length() > 20) {
            throw new loginExp("Длина логина должна быть меньше или ровна 20 символов");
        }
        if (password == null || password.isEmpty() || password.length() >= 20) {
            throw new passwordExp("Длина пароля должна быть меньше 20 символов");
        }
        if (!Objects.equals(password,confirmPassword)) {
            throw new passwordExp("Пароли должны совпадать");
        }
        Checker checker = new Loopchecker();
        checker.check(login, true);
        checker.check(password, false);

    }
}
