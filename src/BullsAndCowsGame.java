import MyExceptions.DuplicateDataException;

import java.util.*;

public class BullsAndCowsGame {
    public static void main(String[] args) {
        BullsAndCowsGame bullsAndCowsGame = new BullsAndCowsGame();
        bullsAndCowsGame.start();
    }

    public void start() {
        // create the game
        Game game = new Game();

        // create the computer and implement the computer by the selected level
        Computer computer = null;
        System.out.println("Please select the level you want to play:");
        game.setLevel();
        switch (game.getLevel()) {
            case 1:
                computer = new EasyLevel();
                computer.setLevel("EASY");
                break;
            case 2:
                computer = new MediumLevel();
                computer.setLevel("MEDIUM");
                break;
            case 3:
                computer = new HardLevel();
                computer.setLevel("HARD");
                break;
            default:
                break;
        }
        System.out.println("Level: " + computer.getLevel());

        // generate computer's secret code
        computer.setSecretCode();

        // create the user
        User user = new User();

        // generate user's secret code
        System.out.println("Please enter your secret code: ");
        user.setSecretCode();
        System.out.println("Your secret code: " + user.toStringForCode(user.secretCode));

        // play the game
        game.play(user, computer);

    }
}
