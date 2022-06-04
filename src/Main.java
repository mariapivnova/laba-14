import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите t ");
        int t = scanner.nextInt();
        Formula did = new Formula(t);
        did.displayFormula();
        System.out.print("Введите слово ");
        String word = scanner.next();
        if (word.equals("save")) {
            try (ObjectOutputStream fww = new ObjectOutputStream(new FileOutputStream("D://L 14.txt"))) {
                fww.writeObject(did);
                fww.writeInt(t);
                System.out.println("Успешно");

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Ошибка");
        }
        System.out.print("Введите второе слово ");
        String word2 = scanner.next();
        if (word2.equals("upload")) {
            try (ObjectInputStream pt = new ObjectInputStream(new FileInputStream("D://L 14.txt"))) {
                Formula form = (Formula) pt.readObject();
                System.out.println(form.t);
                System.out.println("второе слово введено успешно");
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        else {
            System.out.println("ошибка при введении второго слова");
        }
    }
}
class Formula implements Serializable {
    float t;

    public Formula(float t) {
        this.t = t;
    }

    public void displayFormula() {
        double vector = t- (Math.sin(t));
        System.out.println(vector);
    }
}