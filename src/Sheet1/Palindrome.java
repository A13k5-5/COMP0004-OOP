package Sheet1;

import java.util.ArrayList;

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

    private ArrayList<String> getFileInput(String fileName) {
        if (!FileInput.exists(fileName)) {
            System.err.println("File" + fileName + " does not exist.");
            System.exit(1);
        }
        FileInput in = new FileInput(fileName);
        ArrayList<String> words = new ArrayList<>();
        while (in.hasNextLine()) {
            words.add(in.nextLine().strip());
        }
        in.close();
        return words;
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

    public void testForPalindrome(ArrayList<String> words) {
        for (String word : words) {
            System.out.println(word + " " + check(tidyString(word), tidyString(word)));
        }
    }

    public void go() {
//        testForPalindrome(getInput());
        testForPalindrome(getFileInput("palindromes.txt"));
    }

    public static void main(String[] args) {
        new Palindrome().go();
    }
}