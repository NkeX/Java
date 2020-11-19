/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr18myschool;

import entity.Journal;
import entity.Person;
import entity.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tools.manager.JournalManager;
import tools.manager.LoginManager;
import tools.manager.PersonManager;
import tools.manager.SubjectManager;
import tools.savers.SaveToFile;

/**
 * @author sillamae kutsekool
 */
class App {
    private Scanner scanner = new Scanner(System.in);

    private List<Person> listPersons;
    private List<Subject> listSubjects;
    private List<Journal> listJournals;

    private PersonManager personManager = new PersonManager();
    private SubjectManager subjectManager = new SubjectManager();
    private JournalManager journalManager = new JournalManager();

    private Person loggedPerson = null;

    public App() {
        SaveToFile saveToFile = new SaveToFile();
        this.listPersons = saveToFile.loadFromFile("listPersons");
        this.listSubjects = saveToFile.loadFromFile("listSubjects");
        this.listJournals = saveToFile.loadFromFile("listJournals");
    }

    public void run() {
        LoginManager loginManager = new LoginManager(listPersons);
        System.out.println("--- Моя школа ---");
        boolean repeat = true;
        do {
            System.out.println("Задачи:");
            System.out.println("0. Exit");
            System.out.println("1. Регистрация");
            System.out.println("2. Вход в систему");
            System.out.println("Выберите задачу:");
            Scanner scanner = new Scanner(System.in);
            String enter = scanner.nextLine();
            switch (enter) {
                case "0":
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case "1":
                    loggedPerson = loginManager.register();
                    personManager.addPersonToList(loggedPerson, listPersons);
                    repeat = false;
                    break;
                case "2":
                    loggedPerson = loginManager.login();
                    repeat = false;
                    break;
                default:
                    System.out.println("Нет такой задачи. Выберите из списка.");
            }
        } while (repeat);

        menu();
    }

    void menu() {

        if (loggedPerson == null){
            System.out.println("Вы не залогинены, пожалуйста пройдите регистрацию");
            run();
        }
        else {
            System.out.println("Здравствуйте " + loggedPerson.getFirstName() + " " + loggedPerson.getLastName() + "!");
            if (loggedPerson.getRole().equals("TEACHER")) {
                boolean repeat = true;
                do {
                    System.out.println("Задачи:");
                    System.out.println("0. Выход из программы");
                    System.out.println("1. Добавить ученика");
                    System.out.println("2. Список учеников");
                    System.out.println("3. Добавить учителя");
                    System.out.println("4. Список учителей");
                    System.out.println("5. Добавить предмет");
                    System.out.println("6. Список предметов");
                    System.out.println("7. Выставить оценку");
                    System.out.println("8. Оценки ученика");
                    System.out.println("9. Оценки по предмету");
                    System.out.println("Выберите задачу:");
                    String enter = scanner.nextLine();
                    switch (enter) {
                        case "0":
                            System.out.println("Выход из программы");
                            repeat = false;
                            break;
                        case "1":
                            Person student = personManager.createPerson("STUDENT");
                            personManager.addPersonToList(student, listPersons);
                            break;
                        case "2":
                            personManager.printListStudents(listPersons);
                            break;
                        case "3":
                            Person teacher = personManager.createPerson("TEACHER");
                            personManager.addPersonToList(teacher, listPersons);
                            break;
                        case "4":
                            personManager.printListTeachers(listPersons);
                            break;
                        case "5":
                            Subject subject = subjectManager.createSubject(listPersons);
                            subjectManager.addSubjectToList(subject, listSubjects);
                            break;
                        case "6":
                            subjectManager.printListSubjects(listSubjects);
                            break;
                        case "7":
                            journalManager.setMarkToUser(listSubjects, listPersons, listJournals);
                            break;
                        case "8":
                            journalManager.printMarksUser(listPersons, listJournals);
                            break;
                        case "9":
                            journalManager.printMarksForSubject(listJournals, listSubjects);
                            break;
                        default:
                            System.out.println("Нет такой задачи. Выберите из списка.");
                    }
                } while (repeat);
            }
            else if((loggedPerson.getRole().equals("STUDENT"))){
                boolean repeat = true;
                do {
                    System.out.println("Задачи:");
                    System.out.println("0. Выход из программы");
                    System.out.println("1. Список учеников");
                    System.out.println("2. Список учителей");
                    System.out.println("3. Список предметов");
                    System.out.println("4. Оценки по предмету");
                    System.out.println("Выберите задачу:");
                    String enter = scanner.nextLine();
                    switch (enter) {
                        case "0":
                            System.out.println("Выход из программы");
                            repeat = false;
                            break;
                        case "1":
                            personManager.printListStudents(listPersons);
                            break;
                        case "2":
                            personManager.printListTeachers(listPersons);
                            break;
                        case "3":
                            subjectManager.printListSubjects(listSubjects);
                            break;
                        case "4":
                            journalManager.printMarksForSubject(listJournals, listSubjects);
                            break;
                        default:
                            System.out.println("Нет такой задачи. Выберите из списка.");
                            ;
                    }
                } while (repeat);
            }
        }

    }
}
