package xoxo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Component;

import xoxo.util.SpringUtilities;

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
        // create components
        messageField = new JTextField(20);
        keyField = new JTextField(20);
        seedField = new JTextField(20);
        logField = new JTextArea(5, 20);
        encryptButton =  new JButton("encrypt");
        decryptButton = new JButton("decrypt");
        
        // so text area does not grow, but go to next line
        logField.setLineWrap(true);
        logField.setWrapStyleWord(true);

        // create container for field and label message, key and seed
        JPanel panel = new JPanel(new SpringLayout());
        String[] labels = new String[] {"message: ", "key: ", "seed: "};
        JComponent[] fields = new JComponent[] {messageField, keyField, seedField};
        for(int i=0; i<3; i++){
            panel.add(new JLabel(labels[i], JLabel.TRAILING));
            panel.add(fields[i]);
        }
        SpringUtilities.makeCompactGrid(panel, 3, 2, 6, 6, 6, 6);
        panel.setOpaque(true);

        // create container for encrypt and decrypt buttons
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
        panel2.add(encryptButton);
        panel2.add(Box.createRigidArea(new Dimension(10, 1)));
        panel2.add(decryptButton);

        // create parent container for above two containers
        JPanel parentPanel = new JPanel(new SpringLayout());
        parentPanel.add(panel);
        parentPanel.add(panel2);
        parentPanel.add(logField);
        SpringUtilities.makeCompactGrid(parentPanel, 3, 1, 6, 6, 6, 6);
        parentPanel.setOpaque(true);

        // create frame object
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(parentPanel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
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