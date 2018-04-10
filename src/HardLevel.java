import MyExceptions.DuplicateDataException;

import java.util.ArrayList;
import java.util.List;

public class HardLevel extends Computer {
    List<int[]> possibleCodes = new ArrayList<int[]>();
    int[] tempGuess = new int[LENGTH_OF_CODE];

    public HardLevel() {
        // initiallise possibleCodes for 1st round (put all possible codes into possibleCodes)
        String s = "";
        for (int i = 123; i <= 9876; i++) {
            s = Integer.toString(i);
            if (s.length() == 3) {
                s = "0" + s;
            }
            try {
                for (int j = 0; j < LENGTH_OF_CODE; j++) {
                    int value = Integer.parseInt(s.charAt(j) + "");
                    for (int k = 0; k < j; k++) {
                        if (value == tempGuess[k]) {
                            throw new DuplicateDataException();
                        }
                    }
                    tempGuess[j] = value;
                }
                possibleCodes.add(tempGuess.clone());
            } catch (DuplicateDataException e) {
                continue;
            }
        }
        // for testing purpose
//        for (int i = 0; i < possibleCodes.size(); i++) {
//            System.out.println();
//            System.out.print(possibleCodes.get(i)[0]);
//            System.out.print(possibleCodes.get(i)[1]);
//            System.out.print(possibleCodes.get(i)[2]);
//            System.out.print(possibleCodes.get(i)[3]);
//            System.out.println();
//        }
    }

    @Override
    public void guess(Players player, Players answer) {
        //select one guess from possibleCode
        int randomIndex = (int)(Math.random() * this.possibleCodes.size());
        for (int i = 0; i < LENGTH_OF_CODE; i++){
            this.guess[i] = this.possibleCodes.get(randomIndex)[i];
        }
        //check answer
        this.checkAnswer(player.guess, answer.secretCode);
        // update possibleCodes
        List<int[]> tempPossibleCodes = new ArrayList<int[]>(); // store the codes which will be removed later
        // use tempBulls & tempCows to keep the values of bulls & cows
        int tempBulls = this.bulls;
        int tempCows = this.cows;
        for (int i = 0; i < this.possibleCodes.size(); i++){
            this.checkAnswer(this.possibleCodes.get(i), player.guess); //assume player's guess as the secret code
            if (tempBulls != this.bulls || tempCows != this.cows){
                tempPossibleCodes.add(this.possibleCodes.get(i));
            }
        }
        // give the value back to bulls & cows
        this.bulls = tempBulls;
        this.cows = tempCows;
        // remove all codes which don't match the same result.
        for (int i = 0; i < tempPossibleCodes.size(); i++){
            this.possibleCodes.remove(tempPossibleCodes.get(i));
        }
    }
}
