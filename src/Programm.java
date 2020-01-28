import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Programm{

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Please input start for run: ");     // ожидание ввода команды старта
        try {
            String start = in.next("start");            // прооверка вводимой команды на соответствие необходимому паттерну
            System.out.print("Let`s go"  +  "\n");
            in.close();
            Resource s = null;
            try {
                s = new Resource ("thread.txt");            // создание файла для записи
                Thread t1 = new Thread("Project A ", s);  // создание потока 1
                Thread t2 = new Thread("Project B ", s);  // создание потока 2
                t1.start();                                      // старт потока 1
                t2.start();                                      // старт потока 2
                t1.join();                                       // слушатель потока 1
                if(t2.isAlive()){                                // проверка потока 2 на завершенность
                t2.join();                                       // ждём пока поток 2 закончит счёт
                s.win(t1.getName());                             // определение потока победителя
                s.lose(t2.getName());                            // определение проигравшего потока
                }
                else{
                    s.win(t2.getName());                          // определение потока победителя
                    s.lose(t1.getName());                         // определение проигравшего потока
                }
            } catch (IOException e) {
                System.err.print("File error: " + e);
            } catch (InterruptedException e) {
                System.err.print("Thread error: " + e);
            } finally {
                s.close();
            }
        }
        catch (InputMismatchException e){
            System.out.println( "You input wrong command");
        }
    }
}