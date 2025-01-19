package Sheet1;

import java.util.ArrayList;

public class SortInputWords {
    public ArrayList<String> input(int n) {
        Input inp = new Input();
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            words.add(inp.nextLine());
        }
        inp.close();
        return words;
    }

    public static void main(String[] args) {
        SortInputWords sortInputWords = new SortInputWords();
        ArrayList<String> words = sortInputWords.input(4);
        System.out.println(words);
        words.sort(String::compareToIgnoreCase);
        System.out.println(words);
    }
}
