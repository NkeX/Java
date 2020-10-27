package jptvr19library;

import tools.ReaderSaver;
import entity.Reader;
import entity.Hind;
import entity.History;
import entity.User;
import java.util.Scanner;
import tools.SecureManager;
import tools.HindSaver;
import tools.HistorySaver;
import tools.UserSaver;
import ui.ManagerUI;
import ui.ReaderUI;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private Reader[] readers = new Reader[10];
    private Hind[] hinds = new Hind[10];
    private History[] histories = new History[10];
    private User[] users = new User[100];
    private SecureManager secureManager = new SecureManager();
    private User loginedUser;


    public App() {
        ReaderSaver rsm = new ReaderSaver();
        Reader[] loadedReaders = rsm.loadFile();
        if(loadedReaders != null){
            readers = loadedReaders;
        }
        HindSaver bsm = new HindSaver();
        Hind[] loadedHinds = bsm.loadFile();
        if(loadedHinds != null){
            hinds = loadedHinds;
        }
        HistorySaver historiesStorageManager = new HistorySaver();
        History[] loaderHistories = historiesStorageManager.loadFile();
        if(loaderHistories != null){
            histories = loaderHistories;
        }
        UserSaver userStoreManager = new UserSaver();
        User[] loadedUsers = userStoreManager.loadFile();
        if(loadedUsers != null){
            users = loadedUsers;
        }
    }

    public void run() {
        System.out.println("--- Библиотека ---");

        this.loginedUser = SecureManager.checkTask(users, readers);
        if(SecureManager.Role.READER.toString().equals(loginedUser.getRole())){
            ReaderUI readerUI = new ReaderUI();
            readerUI.getReaderUI(hinds, readers, histories);
        }else if(SecureManager.Role.MANAGER.toString().equals(loginedUser.getRole())){
            ManagerUI managerUI = new ManagerUI();
            managerUI.getManagerUI(hinds, readers, histories);

        }

    }

}