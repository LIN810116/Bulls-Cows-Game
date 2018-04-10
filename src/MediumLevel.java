import java.util.ArrayList;
import java.util.List;
public class MediumLevel extends Computer {
    private List guesses = new ArrayList(); //to store the guesses it has already made

    @Override
    public void guess(Players player, Players answer) { //In this level, AI won't make the same guess twice
        int[] tempGuess = new int[LENGTH_OF_CODE]; // to store the temporary guess
        tempGuess = this.generateRandomNumbers();
        if (! guesses.contains(tempGuess)){
            guesses.add(tempGuess.clone());
            this.guess = tempGuess;
        }
        else {
            this.guess(player, answer); //recursion
        }
//        List<> tempGuess = new ArrayList(); // to store the temporary guess
//        tempGuess = this.generateRandomNumbers();
//        if (! guesses.contains(tempGuess)){
//            guesses.add(tempGuess);
//            this.guess = tempGuess;
//        }
//        else {
//            tempGuess.clear();
//            this.guess(); //recursion
//        }
        this.checkAnswer(player.guess, answer.secretCode);
//        this.bulls = this.tempBulls;
//        this.cows = this.tempCows;
    }
}
