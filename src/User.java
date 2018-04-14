import MyExceptions.DuplicateDataException;

import java.util.ArrayList;
import java.util.List;

public class User extends Players {

    public User() {
        this.setName("You");
    }

    public void setCode(int[] target){
        String input;
        while (true) {
            // auto
            if (this.codeFromFile.size() > 0){
                input = this.codeFromFile.removeFirst();
            }
            // manu
            else {
                input = Keyboard.readInput();
            }
            // check input
            if (this.checkInput(input)) {
                break;
            }
        }
        // set values
        for(int i = 0; i < LENGTH_OF_CODE; i++){
            target[i] = Integer.parseInt(input.charAt(i) + "");
        }
    }

    @Override
    public void guess(Players player, Players answer) {
        this.setCode(this.guess);
        this.checkAnswer(player.guess, answer.secretCode);
    }

    @Override
    public void setSecretCode() {
        this.setCode(this.secretCode);
    }
}
