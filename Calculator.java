import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Calculator {
    public static void main(String[] args) {
        function();
    }

    public static void logo(String str){
        Logger logger = Logger.getAnonymousLogger();
        String pathFile = "file.txt";
        String pathLog = "log.txt";
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler handler = null;
        try {
            handler = new FileHandler(pathLog, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.addHandler(handler);
        handler.setFormatter(formatter);
        try (FileWriter file = new FileWriter(pathFile, true)){
            file.write("\n");
            file.write(str);
            file.flush();
            logger.info("Произведено логирование");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка");
            logger.warning("Ошибка");
        }
        handler.close();
    }

    public static void function(){

        System.out.println("Что будем делать?");
        System.out.println("1: Складывать ");
        System.out.println("2: Умножать");
        System.out.println("3: Делить");
        System.out.println("4: Отбой");
        Scanner scan = new Scanner(System.in);
        int choise = scan.nextInt();
        switch (choise) {
            case 1:
                System.out.println("Первое число - ");
                StartInterface summa = new SummaDecorator(new StartNumber());
                String resultSumma = "Сумма равна:\n" + summa.getResult();
                System.out.println(resultSumma);
                logo(resultSumma);
                function();
            break;

            case 2:
                System.out.println("Первое число - ");
                StartInterface multiplicator = new MultiDecorator(new StartNumber());
                String resultMultiplicator = "Результат:\n" + multiplicator.getResult();
                System.out.println(resultMultiplicator);
                logo(resultMultiplicator);
                function();
            break;

            case 3:
                System.out.println("Первое число - ");
                StartInterface division = new DivisionDecorator(new StartNumber());
                String resultDivision = "Результат:\n" + division.getResult();
                System.out.println(resultDivision);
                logo(resultDivision);
                function();
            break;

            case 4:
                System.out.println("Готово");
            break;

            default:
                System.out.println("Ошибка");
                System.out.println("У вас 4 варианта: 1, 2, 3 и 4");
                function();
            break;
        }
    }
}
