import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Math.max;

public class Translator {
    public Translator() {
        max_length = 0;
        dict = new HashMap<>();
        translate = new String[]{};
    }
    private HashMap<String, String> dict;
    private Integer max_length;
    private String[] translate;


    public void ReadDict(String filename) throws FileReadException, InvalidFileFormatException, FileNotFoundException {
        File file = new File(filename);
        if (!file.exists()) throw new FileReadException("file doesn't exist!");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.contains("|")) throw new InvalidFileFormatException("Invalid file format!");
                String[] words = line.split("\\|");
                if (words[0] == null || words[1] == null) throw new InvalidFileFormatException("Invalid file format!");
                max_length = max(max_length, words[0].split(" ").length);
                dict.put(words[0], words[1]);
            }
        }
    }

    public void ReadText(String filename) throws FileNotFoundException {
        File file = new File(filename);
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                translate = line.split(" ");
            }
        }
    }

    public String TranslateText() {
        int counter = translate.length;
        String output = "";
        for (int i = 0; i < counter; i++) {
            String word = translate[i];
            for (int n = i; n < (i + max_length - 1); n++) {
                if (n >= counter - 1) break;
                String old_word = word;
                word = old_word + " " + translate[n + 1];
                if (dict.containsKey(word.toLowerCase())) {
                    output = output + dict.get(word.toLowerCase()) + " ";
                    i = i + n;
                }
            }
            if (!dict.containsKey(translate[i].toLowerCase())) {
                output = output + translate[i].toLowerCase() + " ";
            } else {
                output = output + dict.get(translate[i].toLowerCase()) + " ";
            }
        }
        return output;
    }
}
