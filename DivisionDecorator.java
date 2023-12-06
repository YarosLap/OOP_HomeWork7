import java.util.Scanner;

public class DivisionDecorator extends Decorator{

    public DivisionDecorator(StartInterface startInterface) {
        super(startInterface);
    }

    @Override
    public double getResult() {
        Scanner scan = new Scanner(System.in);
        double division = scan.nextInt();
        System.out.println("Второе число - ");
        if (division != 0){
            return startInterface.getResult() / division;
        }
        else{
            System.out.println("Ошибка");
            return 0;
        }
    }
}
