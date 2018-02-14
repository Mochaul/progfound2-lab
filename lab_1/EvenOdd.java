public class EvenOdd {

    public static void main(String[] args) {
        int result = 0;
        int repeat = 10;
        int num;

        for(num = 0; num < repeat; num++){
            if (num % 2 == 0){
                System.out.println("Even");
            }else if (num % 2 == 1){
                System.out.println("Odd");
            }

            if(num == (int)Math.floor(repeat/2)){
                System.out.println("Middle");
            }

            result = result + num;
        }

        System.out.println(Integer.toString(num));
    }
}