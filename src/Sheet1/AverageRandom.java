package Sheet1;

import java.util.Random;

public class AverageRandom {
    public double averageRandom(int n) {
        Random random = new Random();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            double num = (random.nextBoolean() ? 1.0 : -1.0) * random.nextDouble();
            sum += num;
        }
        return sum / n;
    }

    public static void main(String[] args) {
        AverageRandom averageRandom = new AverageRandom();
        System.out.println(averageRandom.averageRandom(10000));
    }
}
