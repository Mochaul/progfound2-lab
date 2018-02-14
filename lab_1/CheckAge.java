public class CheckAge {

    public static void main(String[] args) {
        int age = 19;

        if (age < 10){
            System.out.println("Kids");
        }else if (age < 20){
            System.out.println("Teen");
        }else if (age < 50){
            System.out.println("Adult");
        }else {
            System.out.println("Senior");
        }
    }
}