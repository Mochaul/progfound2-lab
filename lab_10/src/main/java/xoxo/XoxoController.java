package xoxo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import xoxo.crypto.XoxoDecryption;
import xoxo.crypto.XoxoEncryption;
import xoxo.key.HugKey;

/**
 * This class controls all the business
 * process and logic behind the program.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @author <write your name here>
 */
public class XoxoController {

    /**
     * The GUI object that can be used to get
     * and show the data from and to users.
     */
    private XoxoView gui;

    /**
     * Class constructor given the GUI object.
     */
    public XoxoController(XoxoView gui) {
        this.gui = gui;
    }

    /**
     * Main method that runs all the business process.
     */
    public void run() {
        gui.setDecryptFunction(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gui.getMessageText().equals("")){
                    JOptionPane.showMessageDialog(null, "message cannot be empty");
                    return;
                }
                if(gui.getKeyText().equals("")){
                    JOptionPane.showMessageDialog(null, "key cannot be empty");
                    return;
                }

                XoxoDecryption dec = new XoxoDecryption(gui.getKeyText());
                if (gui.getSeedText().equals("")){
                    gui.appendLog(dec.decrypt(gui.getMessageText(), HugKey.DEFAULT_SEED));
                }else{
                gui.appendLog(dec.decrypt(gui.getMessageText(), Integer.parseInt(gui.getSeedText())));
                }
            }
        });

        gui.setEncryptFunction(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gui.getMessageText().equals("")){
                    JOptionPane.showMessageDialog(null, "message cannot be empty");
                    return;
                }
                if(gui.getKeyText().equals("")){
                    JOptionPane.showMessageDialog(null, "key cannot be empty");
                    return;
                }
                
                XoxoEncryption enc = new XoxoEncryption(gui.getKeyText());
                if (gui.getSeedText().equals("")){
                    gui.appendLog(enc.encrypt(gui.getMessageText()).getEncryptedMessage());
                }else{
                    gui.appendLog(enc.encrypt(gui.getMessageText(), Integer.parseInt(gui.getSeedText())).getEncryptedMessage());
                }
            }
        });
    }

    //TODO: Create any methods that you want
}