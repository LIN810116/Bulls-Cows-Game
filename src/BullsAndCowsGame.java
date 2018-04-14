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

        // create the user
        User user = new User();

        // generate user's secret code
        System.out.println("Please enter your secret code: ");
        user.setSecretCode();
        System.out.println("Your secret code: " + user.toStringForCode(user.secretCode));
        game.outputData.add("Your secret code: " + user.toStringForCode(user.secretCode));

        // generate computer's secret code
        computer.setSecretCode();
        game.outputData.add("computer's secret code: " + computer.toStringForCode(computer.secretCode));
        game.outputData.add("------------------------------------------------------------------------");

        //select the mode
        System.out.println("Select the mode to enter your guesses:");
        game.setMode();

        // read input from a file
        if (game.getMode() == "AUTOMATICALLY"){
            game.readFile(user);
        }

        // play the game
        game.play(user, computer);
//        System.out.println(computer.toStringForCode(computer.secretCode));

        //finish the game & save the results
        System.out.println("Do you wish to save the result?");
        game.setSaveResult();
        if (game.getSaveResult()){
            game.saveFile();
        }

    }
}
