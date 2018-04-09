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
    public void guess() {
        this.setCode(this.guess);

    }

    @Override
    public void setSecretCode() {
        this.setCode(this.secretCode);
    }
}
