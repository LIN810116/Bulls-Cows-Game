import java.util.ArrayList;
import java.util.List;
public class MediumLevel extends Computer {
    private List guesses = new ArrayList(); //to store the guesses it has already made

    @Override
    public void guess() { //In this level, AI won't make the same guess twice
        int[] tempGuess = new int[LENGTH_OF_CODE]; // to store the temporary guess
        tempGuess = this.generateRandomNumbers();
        if (! guesses.contains(tempGuess)){
            guesses.add(tempGuess.clone());
            this.guess = tempGuess;
        }
        else {
            this.guess(); //recursion
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
    }
}
