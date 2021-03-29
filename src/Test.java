package src;

import src.Handler.Dictionary;

public class Test {

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("C:\\Users\\Schoo\\Desktop\\Java\\Java-Parsing\\src\\sfsu.txt");
        dictionary.Read();
        dictionary.search("reverse");
    }

}
