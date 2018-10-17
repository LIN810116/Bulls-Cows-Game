import MyExceptions.DuplicateDataException;

import java.util.*;

public abstract class Players {
    //Attributes
    private String name;
    static final int LENGTH_OF_CODE = 4;
    protected int[] secretCode = new int[LENGTH_OF_CODE];
    protected int[] guess = new int[LENGTH_OF_CODE];
    protected int bulls, cows;
    Deque<String> codeFromFile = new ArrayDeque<>();

    //Methods
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

    public abstract void setSecretCode(); //will be implemented in user and computer classes >> different implementations


    public String toStringForCode(int[] code) {
        String s = "";
        for (int i = 0; i < LENGTH_OF_CODE; i++) {
            s = s + code[i];
        }
        return s;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
