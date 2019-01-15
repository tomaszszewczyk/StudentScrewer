package tomaszszewczyk.studentscrewer;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class AddDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldQuestion;
    private JTextField textFieldPoints;
    private JTextField textFieldAnswer;
    private JTextField textFieldOptionA;
    private JTextField textFieldOptionB;
    private JTextField textFieldOptionC;
    private JTextField textFieldOptionD;

    private boolean is_canceled = false;

    public AddDialog() {
        setTitle("Add question");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
        is_canceled = true;

        dispose();
    }

    public boolean isCanceled() {
        return is_canceled;
    }

    public String getQuestion() {
        return textFieldQuestion.getText();
    }

    public String getPoints() {
        return textFieldPoints.getText();
    }

    public String getAnswer() {
        return textFieldAnswer.getText();
    }

    public String getOptionA() {
        return textFieldOptionA.getText();
    }

    public String getOptionB() {
        return textFieldOptionB.getText();
    }

    public String getOptionC() {
        return textFieldOptionC.getText();
    }

    public String getOptionD() {
        return textFieldOptionD.getText();
    }

    public String[] getOptions() {
        List<String> list = new ArrayList<>();

        if(getOptionA().length() != 0)
            list.add(getOptionA());
        if(getOptionB().length() != 0)
            list.add(getOptionB());
        if(getOptionC().length() != 0)
            list.add(getOptionC());
        if(getOptionD().length() != 0)
            list.add(getOptionD());

        return list.toArray(new String[0]);
    }

    public boolean isOptionsEmpty() {
        return getOptionA().length() == 0  &&
               getOptionB().length() == 0  &&
               getOptionC().length() == 0  &&
               getOptionD().length() == 0;
    }

    public void display() {
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        AddDialog dialog = new AddDialog();
        dialog.display();
        System.exit(0);
    }
}
