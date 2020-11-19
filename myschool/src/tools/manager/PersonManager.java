/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.Person;

import java.util.List;
import java.util.Scanner;

import tools.savers.SaveToFile;

/**
 * @author sillamae kutsekool
 */
public class PersonManager {
    private final Scanner scanner = new Scanner(System.in);

    public Person createPerson(String login, String password, String role) {
        if ("STUDENT".equals(role)) {
            System.out.println("--- Добавление ученика ---");
            System.out.println("Имя ученика: ");
            String firstName = scanner.nextLine();
            System.out.println("Фамилия ученика: ");
            String lastName = scanner.nextLine();
            System.out.println("Телефон: ");
            String phone = scanner.nextLine();
            return new Person(login, password, firstName, lastName, phone, role);
        } else if ("TEACHER".equals(role)) {
            System.out.println("--- Добавление учителя ---");
            System.out.println("Имя учителя: ");
            String firstName = scanner.nextLine();
            System.out.println("Фамилия учителя: ");
            String lastName = scanner.nextLine();
            System.out.println("Телефон: ");
            String phone = scanner.nextLine();
            return new Person(login, password, firstName, lastName, phone, role);
        } else {
            System.out.println("Такой роли не существует");
            return null;
        }
    }

    public Person createPerson(String role) {
        if ("STUDENT".equals(role)) {
            System.out.println("--- Добавление ученика ---");
            System.out.println("Имя ученика: ");
            String firstName = scanner.nextLine();
            System.out.println("Фамилия ученика: ");
            String lastName = scanner.nextLine();
            System.out.println("Телефон: ");
            String phone = scanner.nextLine();
            return new Person("admin", "admin", firstName, lastName, phone, role);
        } else if ("TEACHER".equals(role)) {
            System.out.println("--- Добавление учителя ---");
            System.out.println("Имя учителя: ");
            String firstName = scanner.nextLine();
            System.out.println("Фамилия учителя: ");
            String lastName = scanner.nextLine();
            System.out.println("Телефон: ");
            String phone = scanner.nextLine();
            return new Person("admin", "admin", firstName, lastName, phone, role);
        } else {
            System.out.println("Такой роли не существует");
            return null;
        }
    }

    public void addPersonToList(Person student, List<Person> listPersons) {
        listPersons.add(student);
        SaveToFile saveToFile = new SaveToFile();
        saveToFile.saveToFile(listPersons, "listPersons");
    }

    public void printListStudents(List<Person> listPersons) {
        System.out.println("--- Список учеников ---");
        for (int i = 0; i < listPersons.size(); i++) {
            Person person = listPersons.get(i);
            if ("STUDENT".equals(person.getRole())) {
                System.out.printf("%d. %s %s%n"
                        , i + 1
                        , person.getFirstName()
                        , person.getLastName()
                );
            }

        }
    }

    public void printListTeachers(List<Person> listPersons) {
        System.out.println("--- Список преподавателей ---");
        for (int i = 0; i < listPersons.size(); i++) {
            Person person = listPersons.get(i);
            if ("TEACHER".equals(person.getRole())) {
                System.out.printf("%d. %s %s%n"
                        , i + 1
                        , person.getFirstName()
                        , person.getLastName()
                );
            }

        }
    }

}
