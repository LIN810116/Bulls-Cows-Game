import java.util.ArrayList;
import java.util.List;
public class MediumLevel extends Computer {
    private List guesses = new ArrayList(); //to store the guesses it has already made

    @Override
    public void guess(Players player, Players answer) { //In this level, AI won't make the same guess twice
        int[] tempGuess = this.generateRandomNumbers(); // to store the temporary guess
        if (! guesses.contains(tempGuess)){ //check if the tempGuess has already made
            guesses.add(tempGuess.clone());
            this.guess = tempGuess;
        }
        else {
            this.guess(player, answer); //recursion
        }

        this.checkAnswer(player.guess, answer.secretCode);
    }
}
