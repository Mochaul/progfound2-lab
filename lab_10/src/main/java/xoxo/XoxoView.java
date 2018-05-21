package xoxo;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

/**
 * This class handles most of the GUI construction.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @author <write your name here>
 */
public class XoxoView {
    
    /**
     * A field that used to be the input of the
     * message that wants to be encrypted/decrypted.
     */
    private JTextField messageField;

    /**
     * A field that used to be the input of the key string.
     * It is a Kiss Key if it is used as the encryption.
     * It is a Hug Key if it is used as the decryption.
     */
    private JTextField keyField;

    
    /**
     * A field to be the input of the seed.
     */
    private JTextField seedField;

    /**
     * A field that used to display any log information such
     * as you click the button, an output file succesfully
     * created, etc.
     */
    private JTextArea logField; 

    /**
     * A button that when it is clicked, it encrypts the message.
     */
    private JButton encryptButton;

    /**
     * A button that when it is clicked, it decrpyts the message.
     */
    private JButton decryptButton;

    //TODO: You may add more components here

    /**
     * Class constructor that initiates the GUI.
     */
    public XoxoView() {
        this.initGui();
    }

    /**
     * Constructs the GUI.
     */
    private void initGui() {
        //TODO: Construct your GUI here
    }

    /**
     * Gets the message from the message field.
     * 
     * @return The input message string.
     */
    public String getMessageText() {
        return messageField.getText();
    }

    /**
     * Gets the key text from the key field.
     * 
     * @return The input key string.
     */
    public String getKeyText() {
        return keyField.getText();
    }

    /**
     * Gets the seed text from the key field.
     * 
     * @return The input key string.
     */
    public String getSeedText() {
        return seedField.getText();
    }

    /**
     * Appends a log message to the log field.
     *
     * @param log The log message that wants to be
     *            appended to the log field.
     */
    public void appendLog(String log) {
        logField.append(log + '\n');
    }

    /**
     * Sets an ActionListener object that contains
     * the logic to encrypt the message.
     * 
     * @param listener An ActionListener that has the logic
     *                 to encrypt a message.
     */
    public void setEncryptFunction(ActionListener listener) {
        encryptButton.addActionListener(listener);
    }
    
    /**
     * Sets an ActionListener object that contains
     * the logic to decrypt the message.
     * 
     * @param listener An ActionListener that has the logic
     *                 to decrypt a message.
     */
    public void setDecryptFunction(ActionListener listener) {
        decryptButton.addActionListener(listener);
    }
}