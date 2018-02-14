public class Sum {

    public static void main(String[] args) {
        int result = 0;

        for(int a=0; a<10; a++){
            result = result + (a*100 - a);
        }

        System.out.println(Integer.toString(result));
    }
}