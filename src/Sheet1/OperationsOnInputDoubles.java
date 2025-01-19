package Sheet1;

public class OperationsOnInputDoubles {

    double a, b;

    public double inputDouble() {
        Input input = new Input();
        double a =  input.nextDouble();
        input.close();
        return a;
    }

    public double addAndSquare(double a, double b) {
        return Math.sqrt(a + b);
    }

    public double addAndSquare2() {
        return Math.sqrt(this.a + this.b);
    }

    public static void main(String[] args) {
        OperationsOnInputDoubles operationsOnInputDoubles = new OperationsOnInputDoubles();
        double a = operationsOnInputDoubles.inputDouble();
        double b = operationsOnInputDoubles.inputDouble();
        System.out.println(operationsOnInputDoubles.addAndSquare(a, b));

        operationsOnInputDoubles.a = operationsOnInputDoubles.inputDouble();
        operationsOnInputDoubles.b = operationsOnInputDoubles.inputDouble();
        System.out.println(operationsOnInputDoubles.addAndSquare2());

    }

}
