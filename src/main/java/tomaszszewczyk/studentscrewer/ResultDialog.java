package tomaszszewczyk.studentscrewer;

import tomaszszewczyk.studentscrewer.summaries.IMarkStrategy;

import javax.swing.*;
import java.awt.event.*;

public class ResultDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel labelScore;
    private JButton buttonCancel;

    public ResultDialog(int percent, IMarkStrategy.Mark mark) {
        setTitle("Score");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        labelScore.setText(String.format("Score: %d%% %s.", percent, mark.toString()));

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void display() {
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        ResultDialog dialog = new ResultDialog(50, IMarkStrategy.Mark.MARK_3_0);
        dialog.display();
        System.exit(0);
    }
}
