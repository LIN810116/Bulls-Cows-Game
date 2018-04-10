import MyExceptions.DuplicateDataException;

import java.util.List;

public class User extends Players {
    //ToDo Attributes


    //ToDo Methods
    public User() {
        this.setName("You");
    }
    public void setCode(int[] target){
        String input;
        while (true) {
            input = Keyboard.readInput();
            if (this.checkInput(input, target)) {
                break;
            }
        }
        for(int i = 0; i < LENGTH_OF_CODE; i++){
            target[i] = Integer.parseInt(input.charAt(i) + "");
        }
    }

    @Override
    public void guess(Players player, Players answer) {
        this.setCode(this.guess);
        this.checkAnswer(player.guess, answer.secretCode);
//        this.bulls = this.tempBulls;
//        this.cows = this.tempCows;

    }

    @Override
    public void setSecretCode() {
        this.setCode(this.secretCode);
    }
}
