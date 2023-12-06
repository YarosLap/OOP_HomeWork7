import java.util.Scanner;

public class MultiDecorator extends Decorator{

    public MultiDecorator(StartInterface startInterface) {
        super(startInterface);
    }

    @Override
    public double getResult() {
        Scanner scan = new Scanner(System.in);
        double multi = scan.nextInt();
        System.out.println("Второе число - ");
        return startInterface.getResult() * multi;
    }
}
