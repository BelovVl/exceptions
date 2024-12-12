import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        try {
            checkLogin(login);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.print("Повторите пароль: ");
        String confirmPassword = scanner.nextLine();
        try {
            checkPasswords(password, confirmPassword);
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void checkLogin(String login) throws WrongLoginException {
        if (login.length() >= 20) {
            throw new WrongLoginException("Ошибка! Превышена длина логина.");
        }

        CharacterIterator it = new StringCharacterIterator(login);
        while (it.current() != CharacterIterator.DONE) {
            if (it.current() < '0' | it.current() > '9' & it.current() < 'A' |
                    it.current() > 'Z' & it.current() < 'a' & it.current() != '_' | it.current() > 'z') {
                throw new WrongLoginException();
            }
            it.next();
        }
    }

    public static void checkPasswords(String password, String confirmPassword) throws WrongPasswordException {

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Ошибка! Пароли не одинаковые.");
        }

        if (password.length() >= 20) {
            throw new WrongPasswordException("Ошибка! Превышена длина логина.");
        }

        char[] character = password.toCharArray();
        for (char ch : character) {
            if (ch < '0' | ch > '9' & ch < 'A' |
                    ch > 'Z' & ch < 'a' & ch != '_' | ch > 'z') {
                throw new WrongPasswordException();
            }
        }

    }
}
