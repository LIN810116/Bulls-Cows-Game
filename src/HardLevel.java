import MyExceptions.DuplicateDataException;

import java.util.ArrayList;
import java.util.List;

public class HardLevel extends Computer {
    List<int[]> possibleCodes = new ArrayList<int[]>();
    int[] tempGuess = new int[LENGTH_OF_CODE];

    // initiallise possibleCodes for 1st round (put all possible codes into possibleCodes)
    public HardLevel() {
        // initialise possibleCodes
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
    public void guess() {
        //selcet one guess from possibleCode

        //check answer

        // if not 4A, check all other possible with this guess
        //  if it does not match the same result, delete it from possibleCodes

    }
}
