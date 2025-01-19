package Sheet1;

import java.util.Arrays;

public class InputDoubles {
    public double[] input(int n) {
        Input inp = new Input();
        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = inp.nextDouble();
        }
        return nums;
    }

    public double average(double[] nums) {
        return this.sum(nums) / nums.length;
    }

    public double sum(double[] nums) {
        double sum = 0;
        for (double num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        InputDoubles inputDoubles = new InputDoubles();
        double[] nums = inputDoubles.input(2);
        System.out.println(Arrays.toString(nums));
        System.out.println("Average: " + inputDoubles.average(nums));
        System.out.println("Sum: " + inputDoubles.sum(nums));
    }
}
