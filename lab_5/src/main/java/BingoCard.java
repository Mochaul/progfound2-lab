/**
 * BingoCard Template created by Nathaniel Nicholas
 * Template untuk mengerjakan soal bonus tutorial lab 5
 * Template ini tidak wajib digunakan
 * Side Note : Jangan lupa untuk membuat class baru yang memiliki method main untuk menjalankan program dengan spesifikasi yang diharapkan
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

	public String markNum(int num){
		//TODO Implement
		return "hehe";
	}	
	
	public String info(){
		//TODO Implement
		return "hehe";
	}
	
	public void restart(){
		//TODO Implement
		System.out.println("Mulligan!");
	}
	

}
