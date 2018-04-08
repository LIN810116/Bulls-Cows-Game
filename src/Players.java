import MyExceptions.DuplicateDataException;

import java.util.*;
public abstract class Players {
    //ToDo Attributes
    private String name;
    static final int lengthOfCode = 4;
    protected List<Integer> secretCode = new ArrayList<Integer>();
    protected List<Integer> guess = new ArrayList<Integer>();

    //Todo Methods
    public boolean checkInput(String input, List<Integer> target){
        try{
            if (input.length() > lengthOfCode || input.length() < lengthOfCode){
                throw new IndexOutOfBoundsException();
            }
            for (int i = 0; i < lengthOfCode; i++){
                int value = Integer.parseInt(input.charAt(i) + "");
                if (target.contains(value)){ //must be 4 different digits
                    throw new DuplicateDataException();
                }
                target.add(value);
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("The length of the input was invalid, try again:");
            return false;
        }
        catch (NumberFormatException e){
            System.out.println(e.getMessage() + ". Invalid input, try again:");
            return false;
        }
        catch (DuplicateDataException e){ // MyExceptions
            System.out.println("The input contains duplicate data, try again:");
            return false;
        }
        catch (Exception e){
            System.out.println(e.getMessage() + ". Invalid input, try again:");
            return false;
        }
        return true;
    }

    public abstract void guess(); //different roles have different implementations


    //ToDo Setters & Getters
    // name
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    // secretCode
    public abstract void setSecretCode();
    //will be implemented in user and computer classes >> different implementations

    public List<Integer> getSecretCode(){
        return this.secretCode;
    }

    // guess
    public void setGuess(List<Integer> input){
        this.guess = guess;
    }
    public List<Integer> getGuess() {
        return this.guess;
    }

}
