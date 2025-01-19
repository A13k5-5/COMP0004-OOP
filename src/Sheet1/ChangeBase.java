package Sheet1;

import java.util.ArrayList;

public class ChangeBase {
    public String toBase(int num, int newBase) {
        ArrayList<Integer> newNum = new ArrayList<>();
        while (num >= 1) {
            newNum.addFirst(num % newBase);
            num /= newBase;
        }

        StringBuilder result = new StringBuilder();
        for (int digit : newNum){
            result.append(digit);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ChangeBase changeBase = new ChangeBase();
        System.out.println(changeBase.toBase(4, 2));
    }
}
