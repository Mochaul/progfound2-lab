/**
 * This class contains the starter code (template) for working on lab 5.
 * <p>It is not mandatory to use this template for completing lab 5 programming
 * exercise. You are allowed to create your own <code>BingoCard</code> class.</p>
 * <p>As a side note: do not forget to create a new program class that has a
 * main method to run the program according to the specifications described in
 * the README file.</p>
 *
 * @author Nathaniel Nicholas
 * @author TODO: Write your name & NPM here!
 */
public class BingoCard {

    private Number[][] numbers;
    private Number[] numberStates;
    private boolean isBingo;

    public BingoCard(Number[][] numbers, Number[] numberStates) {
        this.numbers = numbers;
        this.numberStates = numberStates;
        this.isBingo = false;
    }

    public Number[][] getNumbers() {
        return numbers;
    }

    public void setNumbers(Number[][] numbers) {
        this.numbers = numbers;
    }

    public Number[] getNumberStates() {
        return numberStates;
    }

    public void setNumberStates(Number[] numberStates) {
        this.numberStates = numberStates;
    }

    public boolean isBingo() {
        return isBingo;
    }

    public void setBingo(boolean isBingo) {
        this.isBingo = isBingo;
    }

    public String markNum(int num) {
        //TODO Implement
        return "hehe";
    }

    public String info() {
        //TODO Implement
        return "hehe";
    }

    public void restart() {
        //TODO Implement
        System.out.println("Mulligan!");
    }


}
