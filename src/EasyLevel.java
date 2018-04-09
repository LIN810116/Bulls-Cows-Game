public class EasyLevel extends Computer{
    @Override
    public void guess() {
        this.guess = this.generateRandomNumbers();
    }
}
