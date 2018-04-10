public class Game {
    private int level;
    private int numberOfTurns = 7; //up to 7 times for each player
    private String winner = null;


    public Game() {
        System.out.println("Welcome to the bulls & cows game.");
    }

    public void play(User user, Computer computer) {
        System.out.println(computer.toStringForCode(computer.secretCode));
        //todo
        for (int i = 1; i <= this.getNumberOfTurns(); i++){
            if (this.winner != null){
                break;
            }
            //user guess first
            System.out.println(i + ": Please enter your guess: ");
            user.guess(user, computer);
//            this.checkAnswer(user, computer);
            this.printResult(user);
            this.printWinner(user, i);
            //computer's turn
            if (this.winner == null) {
                computer.guess(computer, user);
//                this.checkAnswer(computer, user);
                this.printResult(computer);
                this.printWinner(computer, i);
            }
        }
    }

//    public void checkAnswer(Players player, Players answer){
//        this.bulls = 0;
//        this.cows = 0;
//
//        // check bulls
//        for (int i = 0; i < player.LENGTH_OF_CODE; i++){
//            if (player.guess[i] == answer.secretCode[i]){
//                this.bulls++;
//            }
//        }
//        // check cows
//        for (int i = 0; i < player.LENGTH_OF_CODE; i++){
//            for (int j = 0; j < answer.LENGTH_OF_CODE; j++){
//                if (i != j && player.guess[i] == answer.secretCode[j]){
//                    this.cows++;
//                }
//            }
//        }
////        for (int i = 0; i < player.LENGTH_OF_CODE; i++){
////            //check the number of bulls
////            if (player.guess.get(i) == answer.secretCode.get(i)){
////                this.bulls++;
////            }
////            //check the number of cows
////            else {
////                if (answer.secretCode.contains(player.guess.get(i))){
////                    this.cows++;
////                }
////            }
////        }
//    }

    public void printResult(Players player){
        System.out.println(player.getName() + " guessed " + player.toStringForCode(player.guess) + ", scoring " + player.bulls + " bulls and " + player.cows + " cows.");
    }
    public void printWinner(Players player, int count){
        if (player.bulls == player.LENGTH_OF_CODE){
            System.out.println(player.getName() + " win! :)");
            this.winner = player.getName();
            return;
        }
        if (count == this.numberOfTurns && player.getName().equals("Computer")){
            System.out.println("It's a draw.");
            return;
        }
    }

    //Todo getters & setters
    public void setLevel() {
        String input;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("(enter: \"1\",\"2\" or \"3\")");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            input = Keyboard.readInput();
            input = input.toUpperCase();
            switch (input) {
                case "1":
                case "EASY":
                    this.level = 1;
                    isValid = true;
                    break;
                case "2":
                case "MEDIUM":
                    this.level = 2;
                    isValid = true;
                    break;
                case "3":
                case "HARD":
                    this.level = 3;
                    isValid = true;
                    break;
                default:
                    System.out.println("Invalid input, try again!");
                    break;
            }
        }
    }

    public int getLevel() {
        return this.level;
    }

    public int getNumberOfTurns() {
        return this.numberOfTurns;
    }

    public void setWinner(String winner){
        this.winner = winner;
    }

    public String getWinner(){
        return this.winner;
    }

}
