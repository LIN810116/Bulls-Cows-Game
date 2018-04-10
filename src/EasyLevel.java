public class EasyLevel extends Computer{
    @Override
    public void guess(Players player, Players answer) {
        this.guess = this.generateRandomNumbers();
        this.checkAnswer(player.guess, answer.secretCode);
//        this.bulls = this.tempBulls;
//        this.cows = this.tempCows;
    }
}
