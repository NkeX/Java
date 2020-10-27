package ui;

import tools.ReaderSaver;
import tools.ReaderManager;
import entity.Reader;
import entity.Hind;
import entity.History;
import java.util.Scanner;
import tools.UserManager;
import tools.HindManager;
import tools.HistoryManager;
import tools.HindSaver;
import tools.HistorySaver;



/**
 *
 * @author Melnikov
 */
public class ManagerUI {
    private Scanner scanner = new Scanner(System.in);
    private HindManager hindManager = new HindManager();
    private ReaderManager readerManager = new ReaderManager();
    private HistoryManager historyManager = new HistoryManager();
    private HindSaver hindsStorageManager = new HindSaver();
    private ReaderSaver readersStorageManager = new ReaderSaver();
    private HistorySaver historiesStorageManager = new HistorySaver();
    public void getManagerUI(Hind[] hinds, Reader[] readers, History[] histories) {
        boolean repeat = true;
        do{
            System.out.println("=============================");
            System.out.println("Задачи:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить ученика");
            System.out.println("2. Список учеников");
            System.out.println("3. Добавить учителя");
            System.out.println("4. Список учителей");
            System.out.println("5. Выдать книгу");
            System.out.println("6. Вернуть книгу");
            System.out.println("7. Список читаемых книг");
            System.out.print("Выберите задачу: ");
            String task = scanner.nextLine();
            System.out.println("=============================");
            switch (task) {
                case "0":
                    System.out.println("--- конец программы ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- Добавить оценку ---");
                    Hind hind = hindManager.createHind();
                    hindManager.addHindToArray(hind, hinds);
                    hindManager.printListHinds(hinds);
                    hindsStorageManager.saveHinds(hinds);
                    break;
                case "2":
                    System.out.println("--- Список оценок ---");
                    hindManager.printListHinds(hinds);
                    break;
                case "3":
                    System.out.println("--- Добавить ученика ---");
                    Reader reader = readerManager.createReader();
                    readerManager.addReaderToArray(reader, readers);
                    readerManager.printListReaders(readers);
                    readersStorageManager.saveReaders(readers);
                    break;
                case "4":
                    System.out.println("--- Список учеников ---");
                    hindManager.printListHinds(hinds);
                    break;
                case "5":
                    System.out.println("--- Выдать книгу ---");
                    History history = historyManager.takeOnHindToReader(hinds, readers);
                    historyManager.addHindToArray(history, histories);
                    historyManager.printListHistories(histories);
                    hindsStorageManager.saveHinds(hinds);
                    break;
                case "6":
                    System.out.println("--- Вернуть книгу ---");
                    historyManager.returnHind(histories);
                    historiesStorageManager.saveHistories(histories);
                    break;
                case "7":
                    System.out.println("--- Список читаемых книг ---");
                    historyManager.printListHistories(histories);
                    break;
                default:
                    System.out.println("Нет такой задачи");;
            }
        }while(repeat);
    }

}