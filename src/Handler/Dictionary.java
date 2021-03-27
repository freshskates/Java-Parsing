package src.Handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import src.Handler.Data.Word;
import src.Handler.Data.Definition;

public class Dictionary {
    String file;
    HashMap<String, Word> mapped_words = new HashMap<String, Word>();

    public Dictionary(String file) {
        this.file = file;
    }

    public void Read() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(this.file));
            String line = reader.readLine();
            while (line != null) {
                MapWords(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void MapWords(String line) {
        String[] Initial = line.split("\\|", 2);
        String[] definitions = Initial[1].split("\\|"), temp = new String[2];
        Word word = new Word(definitions.length);
        for (int i = 0; i < definitions.length; i++) {
            temp = definitions[i].split(" -=>> ", 2);
            if (temp.length != 2)
                return;
            word.list.add(new Definition(temp[0], temp[1]));
            temp = new String[2];
        }
        mapped_words.put(Initial[0], word);
    }

    public void search(String word) {
        if (!this.mapped_words.containsKey(word))
            return;
        System.out.printf("Word: %s\n", word);
        for (Definition x : this.mapped_words.get(word).list)
            System.out.printf("[%s] %s\n", x.POS, x.meaning);
    }
}
