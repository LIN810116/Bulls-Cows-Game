import java.util.*;

public abstract class Computer extends Players{
    //Todo Attributes
    String level;

    //Todo Methods
    public Computer(){
        this.setName("Computer");
    }

    public List<Integer> generateRandomNumbers(){
        //randomly generates 4 different numbers
        List<Integer> randomNumbers = new ArrayList<Integer>();
        while (randomNumbers.size() < 4){
            int number = (int)(Math.random() * 10);
            if (!randomNumbers.contains(number)){
                randomNumbers.add(number);
            }
        }
        return randomNumbers;
    }

    @Override
    public void setSecretCode() {
        this.secretCode = generateRandomNumbers();
    }


    public void setLevel(String input){
        this.level = input;
    }
    public String getLevel(){
        return this.level;
    }

}
