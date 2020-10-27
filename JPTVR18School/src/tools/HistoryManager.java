package tools;

import entity.Hind;
import entity.History;
import entity.Reader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class HistoryManager {
    private HindManager hindManager = new HindManager();
    private ReaderManager readerManager = new ReaderManager();
    private Scanner scanner = new Scanner(System.in);

    public History takeOnHindToReader(Hind[] hinds, Reader[] readers){
        System.out.println("--- Cписок книг ---");
        hindManager.printListHinds(hinds);
        System.out.print("Выберите номер книги:");
        int hindNumber = scanner.nextInt();
        Hind hind = hinds[hindNumber - 1];
        System.out.println("--- Список читателей ---");
        readerManager.printListReaders(readers);
        System.out.print("Выберите номер читателя:");
        int readerNumber = scanner.nextInt();
        Reader reader = readers[readerNumber - 1];
        Calendar c = new GregorianCalendar();
        History history = new History();
        history.setHind(hind);
        history.setReader(reader);
        history.setTakeOnDate(c.getTime());
        return history;
    }
    public void addHindToArray(History history, History[] histories){
        for (int i = 0; i < histories.length; i++) {
            if(histories[i] == null){
                histories[i]=history;
                break;
            }
        }
    }
    public void printListHistories(History[] histories) {
        for (int i = 0; i < histories.length; i++) {
            if(histories[i]!= null && histories[i].getReturnDate() == null){
                System.out.printf("%3d. Книгу \"%s\" читает %s %s%n"
                        ,i+1
                        ,histories[i].getHind().getName()
                        ,histories[i].getReader().getName()
                        ,histories[i].getReader().getLastname()
                );
                System.out.println("--------------------------------");
            }
        }
    }

    public void returnHind(History[] histories){
        System.out.println("--- Список читаемых книг ---");
        this.printListHistories(histories);
        System.out.print("Выберите номер возвращаемой книги: ");
        int historyNumber = scanner.nextInt();
        Calendar c = new GregorianCalendar();
        histories[historyNumber - 1].setReturnDate(c.getTime());
        System.out.println("Книга "+histories[historyNumber - 1].getHind().getName()+" возвращена.");
    }

} 