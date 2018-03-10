import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Number[][] array = new Number[5][5];
        String[] command, temp;

        // setup 2D array
        for (int i=0; i<5;i++){
            temp = input.nextLine().split(" ");
            for (int j=0; j < 5; j++){
                array[i][j] = new Number(Integer.parseInt(temp[j]), i, j);
            }
        }

        // initialize bingo card
        BingoCard bingo = new BingoCard(array);
        
        while(bingo.isBingo() == false){
            command = input.nextLine().split(" ");
            if(command.length == 2 && command[0].toLowerCase().equals("mark")){
                System.out.println(bingo.markNum(Integer.parseInt(command[1])));
            }else if(command.length == 1 && command[0].toLowerCase().equals("info")){
                System.out.println(bingo.info());
            }else if(command.length == 1 && command[0].toLowerCase().equals("restart")){
                bingo.restart();
            }else if(command.length == 1 && command[0].equals("")){
                break;
            }else{
                System.out.println("Incorrect command");
            }
        }
        
        input.close();
    }
}