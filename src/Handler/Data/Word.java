package src.Handler.Data;

import java.util.ArrayList;

public class Word {
    public ArrayList<Definition> list;

    public Word(int n) {
        this.list = new ArrayList<Definition>(n);
    }
}
