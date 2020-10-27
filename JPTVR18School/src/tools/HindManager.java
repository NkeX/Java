package tools;

import entity.Hind;
import java.util.Scanner;

public class HindManager {
    public Hind createHind() {
        Hind hind = new Hind();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Создание книги ---");
        System.out.print("Название книги: ");
        hind.setName(scanner.nextLine());
        System.out.print("Автор книги: ");
        hind.setAuthor(scanner.nextLine());
        System.out.print("Год издания книги: ");
        hind.setPublishedYear(scanner.nextInt());
        return hind;
    }
    public void addHindToArray(Hind hind, Hind[] hinds){
        for (int i = 0; i < hinds.length; i++) {
            if(hinds[i] == null){
                hinds[i]=hind;
                break;
            }
        }
    }

    public void printListHinds(Hind[] hinds) {
        for (int i = 0; i < hinds.length; i++) {
            if(hinds[i]!= null){
                System.out.printf("%3d. Название книги: %s%n     Автор: %s%n     Год издания: %s%n"
                        ,i+1
                        ,hinds[i].getName()
                        ,hinds[i].getAuthor()
                        ,hinds[i].getPublishedYear()
                );
                System.out.println("--------------------------------");
            }
        }
    }

}