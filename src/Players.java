import MyExceptions.DuplicateDataException;

import java.util.*;

public abstract class Players {
    //ToDo Attributes
    private String name;
    static final int LENGTH_OF_CODE = 4;
//    protected List<Integer> secretCode = new ArrayList<Integer>();
//    protected List<Integer> guess = new ArrayList<Integer>();
    protected int[] secretCode = new int[LENGTH_OF_CODE];
    protected int[] guess = new int[LENGTH_OF_CODE];
    protected int bulls, cows;
//    protected int[] tempGuess = new int[LENGTH_OF_CODE];
//    List<String> codeFromFile = new ArrayList<>();
    Deque<String> codeFromFile = new ArrayDeque<>();

    //Todo Methods
    public boolean checkInput(String input) {
        try {
            if (input.length() > LENGTH_OF_CODE || input.length() < LENGTH_OF_CODE) {
                throw new IndexOutOfBoundsException();
            }
            for (int i = 0; i < LENGTH_OF_CODE; i++) {
                //check if it contains duplicate data
                for (int j = 0; j < LENGTH_OF_CODE; j++) {
                    if (i != j && input.charAt(i) == input.charAt(j)) {
                        throw new DuplicateDataException();
                    }
                }
                //check if the string can be converted to integer
                int numberForChecking = Integer.parseInt(input.charAt(i) + "");
            }

//            for (int i = 0; i < LENGTH_OF_CODE; i++){
//                int value = Integer.parseInt(input.charAt(i) + "");
//                if (target.contains(value)){ //must be 4 different digits
//                    throw new DuplicateDataException();
//                }
//                target.add(value);
//            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("The length of the input was invalid, try again:");
            return false;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + ". Invalid input, try again:");
            return false;
        } catch (DuplicateDataException e) { // MyExceptions
            System.out.println("The input contains duplicate data, try again:");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage() + ". Invalid input, try again:");
            return false;
        }
        return true;
    }

    public abstract void guess(Players player, Players answer); //different roles have different implementations

    public void checkAnswer(int[] guess, int[] secretCode) {
        this.bulls = 0;
        this.cows = 0;
        // check bulls
        for (int i = 0; i < LENGTH_OF_CODE; i++) {
            if (guess[i] == secretCode[i]) {
                this.bulls++;
            }
        }
        // check cows
        for (int i = 0; i < LENGTH_OF_CODE; i++) {
            for (int j = 0; j < LENGTH_OF_CODE; j++) {
                if (i != j && guess[i] == secretCode[j]) {
                    this.cows++;
                }
            }
        }
    }

    //ToDo Setters & Getters
    // name
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // secretCode
    public abstract void setSecretCode(); //will be implemented in user and computer classes >> different implementations

    public int[] getSecretCode() {
        return this.secretCode;
    }

    // guess
    public void setGuess(List<Integer> input) {
        this.guess = guess;
    }

    public int[] getGuess() {
        return this.guess;
    }

    public String toStringForCode(int[] code) {
        String s = "";
        for (int i = 0; i < LENGTH_OF_CODE; i++) {
            s = s + code[i];
        }
        return s;
    }

}
