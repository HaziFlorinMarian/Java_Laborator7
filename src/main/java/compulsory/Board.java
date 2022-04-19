package compulsory;

import java.util.Vector;

public class Board {
    private /*final*/ Vector<String> words;

    public Board() {
        words = null;
    }

    public synchronized void addWord(Player player, String word) {
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }

    @Override
    public String toString() {
        return words.toString();
    }
}
