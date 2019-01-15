package tomaszszewczyk.studentscrewer;

import javax.swing.*;
import java.awt.event.*;

public class CheckDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textAreaAnwer;
    private JLabel labelText;
    private boolean is_canceled = false;

    public CheckDialog(int index) {
        setTitle("Check");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        labelText.setText(String.format("Enter aswer to question %d.", index));

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        is_canceled = false;
        dispose();
    }

    private void onCancel() {
        is_canceled = false;
        dispose();
    }

    public boolean isCanceled() {
        return is_canceled;
    }

    public String getAnswer() {
        return textAreaAnwer.getText();
    }

    public void display() {
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        CheckDialog dialog = new CheckDialog(1);
        dialog.display();
        System.exit(0);
    }
}
