package compulsory;

import java.util.List;
import java.util.Scanner;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;
    public Player(String name) {
        this.name = name;
    }

    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }

        String word = createWord(extracted);
        game.getBoard().addWord(this, word);

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        return true;
    }

    private String createWord(List<Tile> tiles) {
        System.out.println("Available letters" + tiles.toString());

        Scanner scanner = new Scanner(System.in);
        String result = null;
        boolean isDone = false;

        while (!isDone) {
            List<Tile> tmpTiles = tiles;
            System.out.print(this.name + ", please compute your word:");
            result = scanner.nextLine();

            for (char currChar : result.toCharArray()) {
                boolean letterFound = false;
                for (Tile tile : tmpTiles) {
                    if (currChar == tile.getLetter()) {
                        tmpTiles.remove(tile);
                        letterFound = true;
                        break;
                    }
                }

                if (!letterFound && tmpTiles.isEmpty()) {
                    System.out.println("ERROR! You cannot compute word " + result + "using following tiles:" + tiles.toString());
                }
                else {
                    isDone = true;
                }
            }
        }

        return result;
    }

    public void run() {
        while (true) {
            submitWord();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
