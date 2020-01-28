import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread extends java.lang.Thread {

    private Resource rs;

    public Thread(String name, Resource rs) {      // конструктор класса Thread
        super(name);
        this.rs = rs;
    }

    public void run() {
            for (int i = 1; i <= 100; i++) {
                rs.writing(getName(), i);           // место срабатывания синхронизации
            }
    }
}
