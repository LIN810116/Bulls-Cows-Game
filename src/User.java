import MyExceptions.DuplicateDataException;

import java.util.ArrayList;
import java.util.List;

public class User extends Players {
    // Attribute

    // Methods
    public User() {
        this.setName("You");
    }
    public void setCode(int[] target){
        String input;
        while (true) {
            if (this.codeFromFile.size() > 0){ // auto
                input = this.codeFromFile.removeFirst();
            }
            else { // manu
                input = Keyboard.readInput();

            }
            if (this.checkInput(input)) {
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
    }

    @Override
    public void setSecretCode() {
        this.setCode(this.secretCode);
    }
}
