package Sheet1;

public class InputUntilStop {
    public static void input(){
        Input input = new Input();
        String s;
        do {
            s = input.nextLine();
            System.out.println(s);
        } while(s.compareToIgnoreCase("stop") != 0);
    }

    public static void main(String[] args) {
        input();
    }
}
