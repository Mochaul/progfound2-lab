/**
 * This class contains the starter code (template) for working on lab 5.
 * <p>It is not mandatory to use this template for completing lab 5 programming
 * exercise. You are allowed to create your own <code>BingoCard</code> class.</p>
 * <p>As a side note: do not forget to create a new program class that has a
 * main method to run the program according to the specifications described in
 * the README file.</p>
 *
 * @author Nathaniel Nicholas
 * @author Nicolaus Christian Gozali 1706020446
 */
public class BingoCard {

    // PROPERTIES //
    private Number[][] numbers;
    private boolean isBingo = false;

    // CONSTRUCTOR //
    public BingoCard(Number[][] numbers) {
        this.numbers = numbers;
        this.isBingo = false;
    }

    // GETTER SETTER //
    public Number[][] getNumbers() {
        return this.numbers;
    }
    public void setNumbers(Number[][] numbers) {
        this.numbers = numbers;
    }
    public boolean isBingo() {
        return this.isBingo;
    }
    public void setBingo(boolean isBingo) {
        this.isBingo = isBingo;
    }

    // METHODS //
    public String markNum(int num) {
        String output = "";
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if (this.numbers[i][j].getValue() == num){
                    if (this.numbers[i][j].isChecked()) 
                        output = num + " has been crossed";
                    else{
                        this.numbers[i][j].setChecked(true);
                        output = "Crossed " + num;
                    }
                }
            }
        }
        if(output.equals("")) output = num + " is not found on the card";
        // check for horizontal and vertical bingo
        for (int k=0; k<5; k++){
            if(this.numbers[k][0].isChecked() && this.numbers[k][1].isChecked() && this.numbers[k][2].isChecked() && this.numbers[k][3].isChecked() && this.numbers[k][4].isChecked()){
                this.setBingo(true);
            }
            if(this.numbers[0][k].isChecked() && this.numbers[1][k].isChecked() && this.numbers[2][k].isChecked()&& this.numbers[3][k].isChecked() && this.numbers[4][k].isChecked()){
                this.setBingo(true);
            }
        }
        // check for diagonal bingo
        if(this.numbers[0][0].isChecked() && this.numbers[1][1].isChecked() && this.numbers[2][2].isChecked()  && this.numbers[3][3].isChecked() && this.numbers[4][4].isChecked()){
            this.setBingo(true);
        }else if(this.numbers[0][4].isChecked() && this.numbers[1][3].isChecked()  && this.numbers[2][2].isChecked() && this.numbers[3][1].isChecked() && this.numbers[4][0].isChecked()){
            this.setBingo(true);
        }
        if (this.isBingo) return output + "\nBINGO!\n" + this.info();
        else return output;
    }

    public String info() {
        //TODO Implement
        String result = "";
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if (this.numbers[i][j].isChecked()) result += "| X  ";
                else result += String.format("| %02d ", this.numbers[i][j].getValue());
                if(j==4){
                    result += "|";
                    if(i!=4) result+="\n";
                }
            }
        }
        return result;
    }

    public void restart() {
        //TODO Implement
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                this.numbers[i][j].setChecked(false); 
            }
        }
        System.out.println("Mulligan!");
    }


}
