import java.util.Scanner;

public class SummaDecorator extends Decorator{

    public SummaDecorator(StartInterface startInterface) {
        super(startInterface);
    }

    @Override
    public double getResult() {
        Scanner scan = new Scanner(System.in);
        double sum = scan.nextInt();
        System.out.println("Второе число -");
        return startInterface.getResult() + sum;
    }
}
