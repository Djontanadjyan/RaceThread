import java.io.FileWriter;
import java.io.IOException;

public class Resource {
    private FileWriter fileWriter;
    public Resource (String file) throws IOException{
        fileWriter =new FileWriter (file , false);
    }
    public synchronized void writing(String str, int i ) {          // метод записи в файл данных потока
        try {
            fileWriter.append(str + i);
            fileWriter.append("\n");

             System.out.print(str + i  + "\n" );
        } catch (IOException e) {
            System.err.print("File error: " + e);
        }
    }
    public synchronized void win(String str){                       // метод записи в файл данныз о потоке победителе
        try {
            fileWriter.append(str + "win");
            fileWriter.append("\n");
            System.out.print(str  + "win" + "\n" );
        }
        catch (IOException e){
            System.err.print("File error: " + e);
        }

    }
    public synchronized void lose(String str){                      // метод записи в файл данных о проигравшем потоке
        try {
            fileWriter.append(str + "lose");
            fileWriter.append("\n");
            System.out.print(str  + "lose" + "\n" );
        }
        catch (IOException e){
            System.err.print("File error: " + e);
        }
    }
    public void close() {                                           // закрытие файла после записи
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.err.print("File close error: " + e);
        }
    }
}
