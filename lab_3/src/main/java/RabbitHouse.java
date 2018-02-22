
import java.util.Scanner;

public class RabbitHouse {
    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);

        String arg1 = input.next();
        String arg2 = input.next();

        if (arg1.equals("normal")){
            System.out.println(1 + rabbit(arg2.length()));
        }else if (arg1.equals("palindrom")){
            System.out.println(rabbit_palindrome(arg2));
        }else{
            System.out.println("usage: mode string");
        }

        input.close();
    }

    public static int rabbit(int n){
        if (n == 1){
            return 0;
        }
        else{
            return n + n*rabbit(n - 1);
        }
    }

    public static int rabbit_palindrome(String m){
        if (m.length() == 1){
            return 0;
        }else if (isPalindrome(m) == true){
            return 0;
        }else if (isPalindrome(m) == false){
            int tmp = 1;
            String substr;
            for(int i=0; i<m.length(); i++){
                substr = m.substring(0,i) + m.substring(i+1,m.length());
                tmp += rabbit_palindrome(substr);
            }
            return tmp;
        }
        return 0;
    }

    public static boolean isPalindrome(String m){
        if (m.length() <= 1){
            return true;
        }else if(m.charAt(0) == m.charAt(m.length()-1)){
            return isPalindrome(m.substring(1, m.length()-1));
        }else{
            return false;
        }
    }

}