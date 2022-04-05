package compulsory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bag {
    private final Queue<Tile> letters = new LinkedList<>();

    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            letters.add(new Tile(c, getRandomNumber(1, 10)));
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            extracted.add(letters.poll());
        }

        return extracted;
    }

    /**
     * Getting random numbers specifying interval.
     * @param min minimum value
     * @param max maximum value
     * @return random number
     */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
