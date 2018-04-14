import MyExceptions.DuplicateDataException;

import java.util.*;

public abstract class Computer extends Players {
    String level;

    public Computer() {
        this.setName("Computer");
    }

    public int[] generateRandomNumbers() { //randomly generates 4 different numbers
        int[] randomNumbers = new int[LENGTH_OF_CODE];
        for (int i = 0; i < LENGTH_OF_CODE; i++) {
            randomNumbers[i] = (int) (Math.random() * 10);
            for (int j = 0; j < i; j++) {
                if (randomNumbers[i] == randomNumbers[j]) {
                    i--;
                    break;
                }
            }
        }
        return randomNumbers;
//        List<Integer> randomNumbers = new ArrayList<Integer>();
//        while (randomNumbers.size() < 4){
//            int number = (int)(Math.random() * 10);
//            if (!randomNumbers.contains(number)){
//                randomNumbers.add(number);
//            }
//        }
//        return randomNumbers;
    }

    @Override
    public void setSecretCode() {
        this.secretCode = generateRandomNumbers();
    }

    public void setLevel(String input) {
        this.level = input;
    }

    public String getLevel() {
        return this.level;
    }

}
