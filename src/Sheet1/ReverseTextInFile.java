package Sheet1;

import java.util.ArrayList;

public class ReverseTextInFile {
    public void reverseFileText(String fileName) {
        if (!FileInput.exists(fileName)) {
            System.err.println("File" + fileName + " does not exist.");
            System.exit(1);
        }

        FileInput in = new FileInput(fileName);
        ArrayList<Character> chars = new ArrayList<>();
        while (in.hasNextChar()) {
            char c = in.nextChar();
            chars.add(c);
        }
        in.close();

        FileOutput out = new FileOutput(fileName);

        for (int i = chars.size() - 1; i >= 0; i--) {
            out.writeChar(chars.get(i));
        }
        out.close();
    }

    public static void main(String[] args) {
        new ReverseTextInFile().reverseFileText("data.txt");
    }

}