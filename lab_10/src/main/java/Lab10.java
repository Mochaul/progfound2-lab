import xoxo.XoxoView;
import xoxo.XoxoController;

/**
 * Main class that runs the Xoxo Controller.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @author <write your name here>
 */
public class Lab10 {

    /**
     * The main method.
     * 
     * @param args Argument strings.
     */
    public static void main(String[] args) {
        XoxoView view = new XoxoView();
        XoxoController controller = new XoxoController(view);
        controller.run();
    }
    
}
