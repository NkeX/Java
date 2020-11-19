package tools.manager;

import entity.Person;

import java.util.List;
import java.util.Scanner;

public class LoginManager {
    private final PersonManager personManager = new PersonManager();
    private List<Person> listPersons;

    public LoginManager(List<Person> listPersons) {
        this.listPersons = listPersons;
    }

    public Person login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        for (int i = 0; i < listPersons.size(); i++) {
            Person person = listPersons.get(i);
            if(person.getLogin().equals(login) && person.getPassword().equals(password)){
                return person;
            }
        }
        return null;
    }

    public Person register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        while (true) {
            System.out.println("Выберите роль");
            System.out.println("1. Учитель");
            System.out.println("2. Ученик");
            String enterForIncludeWhile = scanner.nextLine();
            switch (enterForIncludeWhile) {
                case "1":
                    return personManager.createPerson(login, password, "TEACHER");
                case "2":
                    return personManager.createPerson(login, password, "STUDENT");
                default:
                    System.out.println("Ошибка. Выберите из списка.");
            }
        }
    }

}
