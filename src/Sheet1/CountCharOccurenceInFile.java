package Sheet1;

import java.util.HashMap;
import java.util.Map;

public class CountCharOccurenceInFile {
    public void countOccurence(String fileName) {
        if (!FileInput.exists(fileName)) {
            System.err.println("File" + fileName + " does not exist.");
            System.exit(1);
        }

        HashMap<Character, Integer> charCountMap = new HashMap<>();

        FileInput in = new FileInput(fileName);
        while (in.hasNextChar()) {
            char c = in.nextChar();
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        in.close();


    }

    public static void main(String[] args) {
        new CountCharOccurenceInFile().countOccurence("data.txt");
    }
}
