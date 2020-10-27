package tools;

import entity.Hind;
import entity.Reader;
import java.util.Scanner;

public class ReaderManager {

    public Reader createReader() {
        Reader reader = new Reader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Регистрация читателя ---");
        System.out.print("Имя: ");
        reader.setName(scanner.nextLine());
        System.out.print("Фамилия: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Телефон: ");
        reader.setPhone(scanner.nextLine());
        return reader;
    }

    public void addReaderToArray(Reader reader, Reader[] readers) {
        for (int i = 0; i < readers.length; i++) {
            if(readers[i] == null){
                readers[i]=reader;
                break;
            }
        }
    }
    public void printListReaders(Reader[] readers) {
        for (int i = 0; i < readers.length; i++) {
            if(readers[i]!= null){
                System.out.printf("%3d. Добавлен читатель: %s %s%n     Номер телефона: %s%n"
                        ,i+1
                        ,readers[i].getName()
                        ,readers[i].getLastname()
                        ,readers[i].getPhone()
                );
                System.out.println("--------------------------------");
            }
        }
    }

}