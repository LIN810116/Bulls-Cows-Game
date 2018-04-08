import MyExceptions.DuplicateDataException;

import java.util.List;

public class User extends Players {
    //ToDo Attributes


    //ToDo Methods
    public User() {
        this.setName("You");
    }
    public void setCode(List<Integer> target){
        while (true) {
            target.clear();
            if (this.checkInput(Keyboard.readInput(), target)) {
                break;
            }
        }
    }

    @Override
    public void guess() {
        //todo
        this.setCode(this.guess);

    }

    @Override
    public void setSecretCode() {
        this.setCode(this.secretCode);
    }
}
