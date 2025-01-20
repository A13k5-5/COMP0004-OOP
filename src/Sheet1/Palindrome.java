package Sheet1;

public class Palindrome {
    private String reverse(final String s) {
        String result = new String();
        int position = 0;
        while (position < s.length()) {
            result = s.charAt(position) + result;
            position++;
        }
        return result;
    }

    private boolean check(final String s1, final String s2) {
        String s = reverse(s2);
        return s1.equals(s);
    }

    private String getInput() {
        Input in = new Input();
        System.out.println("Enter text to check: ");
        String input = in.nextLine();
        in.close();
        return input;
    }

    private String tidyString(final String s) {
        return s.replaceAll(" ", "").replaceAll("[.,!?]", "").toLowerCase();
    }

    public void testForPalindrome(final String s) {
        if (check(tidyString(s), tidyString(s))) {
            System.out.println("It is a palindrome");
            return;
        }
        System.out.println("It is not a palindrome");
    }

    public void go() {
        testForPalindrome(getInput());
    }

    public static void main(String[] args) {
        new Palindrome().go();
    }
}