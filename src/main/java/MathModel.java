public class MathModel {
    private int firstNumber;
    private int secondNumber;
    private int result;

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getResult() {
        return result;
    }

    public void add() {
        this.result = this.firstNumber + this.secondNumber;
    }
}