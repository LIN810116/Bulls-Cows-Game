import javafx.beans.binding.When;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private int level;
    private int numberOfTurns = 7; //up to 7 times for each player
    private String winner = null;
    private String mode;
    private boolean saveResult;
    List<String> outputData = new ArrayList();

    public Game() {
        System.out.println("Welcome to the bulls & cows game.");
        outputData.add("Bulls & Cows game result.");
    }

    public void play(User user, Computer computer) {
//        System.out.println(computer.toStringForCode(computer.secretCode)); // for testing purpose
        for (int i = 1; i <= this.getNumberOfTurns(); i++){
            if (this.winner != null){
                break;
            }
            outputData.add("Turn " + Integer.toString(i) + ": ");
            System.out.println("Turn " + Integer.toString(i) + ": ");
            //user guess first
            if (this.getMode().equals("MANUALLY") || (this.getMode().equals("AUTOMATICALLY") && user.codeFromFile.size() == 0)){
                System.out.println("Please enter your guess: ");
            }
            user.guess(user, computer);
            this.printResult(user);
            this.printWinner(user, i);
            //computer's turn
            if (this.winner == null) {
                computer.guess(computer, user);
                this.printResult(computer);
                this.printWinner(computer, i);
            }
            outputData.add("------------------------------------------------------------------------");
        }
    }

    public void printResult(Players player){
        String output = player.getName() + " guessed " + player.toStringForCode(player.guess) + ", scoring " + player.bulls + " bulls and " + player.cows + " cows.";
        System.out.println(output);
        outputData.add(output);
    }

    public void printWinner(Players player, int count){
        if (player.bulls == player.LENGTH_OF_CODE){
            String output = "The winner is " + player.getName() + " :)";
            System.out.println(output);
            outputData.add(output);
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

    public void setMode(){
        String input;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("1. Automatically");
            System.out.println("2. Manually");
            input = Keyboard.readInput();
            input = input.toUpperCase();
            switch (input) {
                case "1":
                case "AUTOMATICALLY":
                    this.mode = "AUTOMATICALLY";
                    isValid = true;
                    break;
                case "2":
                case "MANUALLY":
                    this.mode = "MANUALLY";
                    isValid = true;
                    break;
                default:
                    System.out.println("Invalid input, try again!");
                    break;
            }
        }
    }
    public String getMode(){
        return this.mode;
    }

    public void readFile(Players user){
        while (true){
            System.out.println("Please enter an valid file: ");
            String filename = Keyboard.readInput();
            File inputFile = new File(filename);
            try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
                String line = null;
                while ((line = reader.readLine()) != null){
                    // assume each line of the file contain a valid guess
                    // otherwise, need to check the value, use "user.checkInput(line)"
                    user.codeFromFile.addLast(line);
                }
            }
            catch (IOException e){
                System.out.println("The file doesn't exist, try again!");
                continue;
            }
            break;
        }
    }

    public void setSaveResult(){
        String input;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("1. Yes");
            System.out.println("2. No");
            input = Keyboard.readInput();
            input = input.toUpperCase();
            switch (input) {
                case "1":
                case "YES":
                    this.saveResult = true;
                    isValid = true;
                    break;
                case "2":
                case "NO":
                    this.saveResult = false;
                    isValid = true;
                    break;
                default:
                    System.out.println("Invalid input, try again!");
                    break;
            }
        }
    }

    public boolean getSaveResult(){
        return this.saveResult;
    }

    public void saveFile(){
        while (true){
            System.out.println("Enter the file name:");
            String filename = Keyboard.readInput();
            File outputFile = new File(filename);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (int i = 0; i < outputData.size(); i++){
                    writer.write(outputData.get(i));
                    writer.newLine();
                }
            }
            catch (IOException e){
                System.out.println("Error: " + e.getMessage());
                continue;
            }
            break;
        }
    }

}
